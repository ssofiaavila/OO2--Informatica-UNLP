# Patrones de Diseño - Guía de Estudio

## 1. Diferencias entre Template Method, Strategy y State Pattern

### Template Method Pattern
- **Propósito**: Define la estructura de un algoritmo en una clase base, permitiendo que las subclases implementen pasos específicos.
- **Herencia**: Usa **herencia** (relación IS-A).
- **Flexibilidad**: La estructura del algoritmo es **fija**, solo varían los pasos internos.
- **Control**: La clase base controla el flujo; las subclases deben seguirlo.

```typescript
abstract class Procesador {
  procesar(): void {
    this.validar();        // Define estructura fija
    this.procesar();
    this.guardar();
  }
  abstract validar(): void;
  abstract procesar(): void;
  abstract guardar(): void;
}
```

### Strategy Pattern
- **Propósito**: Define una familia de algoritmos intercambiables; el cliente elige cuál usar.
- **Composición**: Usa **composición** (relación HAS-A).
- **Flexibilidad**: El comportamiento es **intercambiable en tiempo de ejecución**.
- **Control**: El cliente decide qué estrategia usar.

```typescript
interface Estrategia {
  ejecutar(): void;
}

class Contexto {
  constructor(private estrategia: Estrategia) {}
  procesar(): void {
    this.estrategia.ejecutar();
  }
}
```

### State Pattern
- **Propósito**: Permite que un objeto cambie su comportamiento cuando su estado interno cambia.
- **Composición**: También usa composición.
- **Flexibilidad**: El comportamiento cambia según el **estado actual**.
- **Control**: El propio objeto gestiona las transiciones de estado.

```typescript
interface Estado {
  manejar(contexto: Contexto): void;
}

class Contexto {
  private estado: Estado = new EstadoInicial();
  cambiarEstado(estado: Estado): void {
    this.estado = estado;
  }
}
```

### Tabla Comparativa

| Aspecto | Template Method | Strategy | State |
|--------|-----------------|----------|-------|
| **Mecanismo** | Herencia | Composición | Composición |
| **Decisión** | En tiempo de compilación | En tiempo de ejecución | Automática (basada en estado) |
| **Control** | Clase base | Cliente | Objeto (contexto) |
| **Cambio** | Crear subclase nueva | Pasar diferente estrategia | Transición de estado |
| **Ejemplo** | Pasos de un algoritmo fijo | Diferentes formas de pagar | Máquina de estados (encendido/apagado) |

### Resumen Clave
- **Template Method** es sobre *cómo* estructura una clase las cosas internamente
- **Strategy/State** son sobre *qué* comportamiento usar y *cuándo* cambiarlo

---

## 2. State Pattern (Implementación Detallada)

### Descripción
El State Pattern es un patrón de comportamiento que permite que un objeto cambie su comportamiento cuando su estado interno cambia. Parece como si el objeto hubiera cambiado su clase. El patrón extrae estados en clases separadas y les permite transicionar entre sí.

### Componentes del Patrón

1. **State**: Interfaz que define los métodos para cada estado
2. **ConcreteState**: Implementa el comportamiento específico de cada estado
3. **Context**: Mantiene una instancia del estado actual y delega las solicitudes al estado actual
4. **Client**: Usa el contexto

### Diagrama UML

```
┌──────────────────────────┐
│    EstadoMusica          │
│   <<interface>>          │
├──────────────────────────┤
│ +reproducir(reproductor) │
│ +pausar(reproductor)     │
│ +detener(reproductor)    │
└────────────┬─────────────┘
             △
             │
    ┌────────┼────────────┐
    │        │            │
┌───┴────────┐ ┌──────────┴───┐ ┌──────────┴────┐
│Reproduciendo│ │Pausado       │ │Detenido      │
├─────────────┤ ├──────────────┤ ├──────────────┤
│+reproducir()│ │+reproducir() │ │+reproducir() │
│+pausar()    │ │+pausar()     │ │+pausar()     │
│+detener()   │ │+detener()    │ │+detener()    │
└─────────────┘ └──────────────┘ └──────────────┘
                        △
                        │
                ┌───────┴──────────┐
                │   Reproductor    │
                ├──────────────────┤
                │-estado: Estado   │
                │-cancion: string  │
                ├──────────────────┤
                │+reproducir()     │
                │+pausar()         │
                │+detener()        │
                │+obtenerEstado()  │
                └──────────────────┘

Las transiciones de estado se hacen automáticamente:
Detenido → Reproduciendo → Pausado → Reproduciendo → Detenido
```

### Ejemplo: Reproductor de Música

```typescript
// 1. Interfaz State: Define el contrato para cada estado
interface EstadoMusica {
  reproducir(reproductor: Reproductor): void;
  pausar(reproductor: Reproductor): void;
  detener(reproductor: Reproductor): void;
}

// 2. ConcreteState: Estado Reproduciendo
class EstadoReproduciendo implements EstadoMusica {
  reproducir(reproductor: Reproductor): void {
    console.log("⚠️ La música ya se está reproduciendo");
  }

  pausar(reproductor: Reproductor): void {
    console.log("⏸️ Música pausada");
    reproductor.establecerEstado(new EstadoPausado());
  }

  detener(reproductor: Reproductor): void {
    console.log("⏹️ Música detenida");
    reproductor.establecerEstado(new EstadoDetenido());
  }
}

// 3. ConcreteState: Estado Pausado
class EstadoPausado implements EstadoMusica {
  reproducir(reproductor: Reproductor): void {
    console.log("▶️ Reanudando música");
    reproductor.establecerEstado(new EstadoReproduciendo());
  }

  pausar(reproductor: Reproductor): void {
    console.log("⚠️ La música ya está pausada");
  }

  detener(reproductor: Reproductor): void {
    console.log("⏹️ Música detenida");
    reproductor.establecerEstado(new EstadoDetenido());
  }
}

// 4. ConcreteState: Estado Detenido
class EstadoDetenido implements EstadoMusica {
  reproducir(reproductor: Reproductor): void {
    console.log("▶️ Iniciando reproducción");
    reproductor.establecerEstado(new EstadoReproduciendo());
  }

  pausar(reproductor: Reproductor): void {
    console.log("⚠️ No puedes pausar música detenida");
  }

  detener(reproductor: Reproductor): void {
    console.log("⚠️ La música ya está detenida");
  }
}

// 5. Context: Reproductor que mantiene el estado
class Reproductor {
  private estado: EstadoMusica;
  private cancion: string;

  constructor(cancion: string) {
    this.cancion = cancion;
    this.estado = new EstadoDetenido();
  }

  establecerEstado(nuevoEstado: EstadoMusica): void {
    this.estado = nuevoEstado;
  }

  reproducir(): void {
    console.log(`\n🎵 Canción: ${this.cancion}`);
    this.estado.reproducir(this);
  }

  pausar(): void {
    this.estado.pausar(this);
  }

  detener(): void {
    this.estado.detener(this);
  }

  obtenerEstado(): string {
    const estadoActual = this.estado.constructor.name;
    if (estadoActual === "EstadoReproduciendo") return "Reproduciendo ▶️";
    if (estadoActual === "EstadoPausado") return "Pausado ⏸️";
    if (estadoActual === "EstadoDetenido") return "Detenido ⏹️";
    return "Desconocido";
  }

  obtenerCancion(): string {
    return this.cancion;
  }
}

// 6. Cliente: Usa el reproductor
class Cliente {
  demostrar(): void {
    console.log("=== DEMOSTRACIÓN STATE PATTERN ===");
    console.log("Reproductor de Música\n");

    const reproductor = new Reproductor("Bohemian Rhapsody - Queen");

    console.log(`Estado inicial: ${reproductor.obtenerEstado()}`);

    // Intentar pausar sin reproducir
    console.log("\n--- Intento 1: Pausar sin reproducir ---");
    reproductor.pausar();

    // Intentar detener sin reproducir
    console.log("\n--- Intento 2: Detener sin reproducir ---");
    reproductor.detener();

    // Reproducir
    console.log("\n--- Intento 3: Reproducir ---");
    reproductor.reproducir();
    console.log(`Estado: ${reproductor.obtenerEstado()}`);

    // Intentar reproducir de nuevo
    console.log("\n--- Intento 4: Reproducir de nuevo (ya está reproduciendo) ---");
    reproductor.reproducir();

    // Pausar
    console.log("\n--- Intento 5: Pausar ---");
    reproductor.pausar();
    console.log(`Estado: ${reproductor.obtenerEstado()}`);

    // Pausar de nuevo
    console.log("\n--- Intento 6: Pausar de nuevo (ya está pausado) ---");
    reproductor.pausar();

    // Reanudar
    console.log("\n--- Intento 7: Reanudar ---");
    reproductor.reproducir();
    console.log(`Estado: ${reproductor.obtenerEstado()}`);

    // Detener
    console.log("\n--- Intento 8: Detener ---");
    reproductor.detener();
    console.log(`Estado: ${reproductor.obtenerEstado()}`);

    // Intentar pausar estando detenido
    console.log("\n--- Intento 9: Pausar música detenida ---");
    reproductor.pausar();

    // Cambiar canción
    console.log("\n--- Intento 10: Reproducir otra canción ---");
    const reproductor2 = new Reproductor("Imagine - John Lennon");
    reproductor2.reproducir();
    console.log(`Estado: ${reproductor2.obtenerEstado()}`);
    reproductor2.pausar();
    console.log(`Estado: ${reproductor2.obtenerEstado()}`);
    reproductor2.reproducir();
    console.log(`Estado: ${reproductor2.obtenerEstado()}`);
  }
}

// Uso
const cliente = new Cliente();
cliente.demostrar();
```

**Salida esperada:**
```
=== DEMOSTRACIÓN STATE PATTERN ===
Reproductor de Música

Estado inicial: Detenido ⏹️

--- Intento 1: Pausar sin reproducir ---
⚠️ No puedes pausar música detenida

--- Intento 2: Detener sin reproducir ---
⚠️ La música ya está detenida

--- Intento 3: Reproducir ---
🎵 Canción: Bohemian Rhapsody - Queen
▶️ Iniciando reproducción
Estado: Reproduciendo ▶️

--- Intento 4: Reproducir de nuevo (ya está reproduciendo) ---
🎵 Canción: Bohemian Rhapsody - Queen
⚠️ La música ya se está reproduciendo

--- Intento 5: Pausar ---
⏸️ Música pausada
Estado: Pausado ⏸️

--- Intento 6: Pausar de nuevo (ya está pausado) ---
⚠️ La música ya está pausada

--- Intento 7: Reanudar ---
🎵 Canción: Bohemian Rhapsody - Queen
▶️ Reanudando música
Estado: Reproduciendo ▶️

--- Intento 8: Detener ---
⏹️ Música detenida
Estado: Detenido ⏹️

--- Intento 9: Pausar música detenida ---
⚠️ No puedes pausar música detenida

--- Intento 10: Reproducir otra canción ---
🎵 Canción: Imagine - John Lennon
▶️ Iniciando reproducción
Estado: Reproduciendo ▶️
⏸️ Música pausada
Estado: Pausado ⏸️
▶️ Reanudando música
Estado: Reproduciendo ▶️
```

### Ventajas del State Pattern

✅ Simplifica código con muchos condicionales (if/else o switch)
✅ Cada estado encapsula su propio comportamiento
✅ Facilita agregar nuevos estados
✅ Las transiciones de estado están centralizadas
✅ El contexto no necesita saber los detalles del estado

### Desventajas

❌ Aumenta el número de clases
❌ Puede ser excesivo para máquinas de estado simples
❌ Requiere que cada estado conozca al contexto

### Cuándo Usarlo

- Un objeto tiene comportamiento que varía según su estado
- Tienes condicionales complejos basados en el estado
- Máquinas de estados (semáforos, reproductores, etc.)
- Workflows con diferentes etapas/estados
- Ejemplos: Reproductores multimedia, máquinas de estados finitos, pedidos en procesos

---

## 3. Template Method Pattern (Implementación Detallada)

### Descripción
El Template Method Pattern es un patrón de comportamiento que define el esqueleto de un algoritmo en una clase base (template), permitiendo que las subclases implementen los pasos específicos sin cambiar la estructura del algoritmo.

### Components del Patrón

1. **Abstract Class**: Define el template method (estructura fija) y métodos abstractos/concretos
2. **Concrete Class**: Implementa los pasos específicos
3. **Client**: Usa las subclases a través de la interfaz base

### Diagrama UML

```
┌─────────────────────────────┐
│  GeneradorReporte           │
│    <<abstract>>             │
├─────────────────────────────┤
│ #datos: string[]            │
├─────────────────────────────┤
│ +generar() void             │
│ +validarDatos() void        │
│ #generarContenido()* void   │
│ #formatear()* string        │
│ #guardar(contenido)* void   │
│ #mostrarMensaje() void      │
└──────────┬──────────────────┘
           △
           │
    ┌──────┴────────┬───────────┐
    │               │           │
┌───┴────────┐ ┌───┴────────┐ ┌┴───────────┐
│PDF Generator│ │Excel Gen.  │ │HTML Gen.   │
├────────────┤ ├────────────┤ ├────────────┤
│+generar()  │ │+generar()  │ │+generar()  │
│-generar... │ │-generar... │ │-generar... │
│-formatear()│ │-formatear()│ │-formatear()│
│-guardar()  │ │-guardar()  │ │-guardar()  │
└────────────┘ └────────────┘ └────────────┘

El flujo en generar():
1. validarDatos() (concreto)
2. generarContenido() (abstracto - implementado en cada subclase)
3. formatear() (abstracto - diferente para cada formato)
4. guardar() (abstracto - diferente para cada tipo)
5. mostrarMensaje() (concreto)
```

### Ejemplo: Generador de Reportes

```typescript
// 1. Clase Abstracta: Define el template method
abstract class GeneradorReporte {
  protected datos: string[];

  constructor(datos: string[]) {
    this.datos = datos;
  }

  // Template Method: Define el flujo general
  public generar(): void {
    console.log("\n📋 Iniciando generación de reporte...");
    this.validarDatos();
    this.generarContenido();
    const contenidoFormateado = this.formatear();
    this.guardar(contenidoFormateado);
    this.mostrarMensaje();
  }

  // Método concreto: Usado por todas las subclases
  protected validarDatos(): void {
    if (this.datos.length === 0) {
      throw new Error("❌ Datos vacíos. No se puede generar el reporte.");
    }
    console.log("✅ Datos validados correctamente");
  }

  // Método concreto: Usado por todas las subclases
  protected mostrarMensaje(): void {
    console.log("✅ Reporte generado exitosamente\n");
  }

  // Métodos abstractos: Cada subclase implementa sus propios detalles
  protected abstract generarContenido(): void;
  protected abstract formatear(): string;
  protected abstract guardar(contenido: string): void;
}

// 2. Subclase Concreta: PDF
class GeneradorPDF extends GeneradorReporte {
  protected generarContenido(): void {
    console.log("📄 Generando contenido en formato PDF...");
  }

  protected formatear(): string {
    const linea = "─".repeat(40);
    let contenido = `\n${linea}\n`;
    contenido += "REPORTE PDF\n";
    contenido += `${linea}\n`;
    this.datos.forEach((dato, index) => {
      contenido += `  ${index + 1}. ${dato}\n`;
    });
    contenido += `${linea}\n`;
    console.log("🎨 Formateando contenido como PDF");
    return contenido;
  }

  protected guardar(contenido: string): void {
    console.log("💾 Guardando como archivo.pdf");
    console.log(contenido);
  }
}

// 3. Subclase Concreta: Excel
class GeneradorExcel extends GeneradorReporte {
  protected generarContenido(): void {
    console.log("📊 Generando contenido en formato Excel...");
  }

  protected formatear(): string {
    let contenido = "\n┌─────────────────────────────────┐\n";
    contenido += "│ REPORTE EXCEL                     │\n";
    contenido += "├─────────────────────────────────┤\n";
    contenido += "│ # │ Contenido                    │\n";
    contenido += "├─────────────────────────────────┤\n";
    this.datos.forEach((dato, index) => {
      contenido += `│ ${index + 1} │ ${dato.padEnd(28)} │\n`;
    });
    contenido += "└─────────────────────────────────┘\n";
    console.log("🎨 Formateando contenido como tabla Excel");
    return contenido;
  }

  protected guardar(contenido: string): void {
    console.log("💾 Guardando como archivo.xlsx");
    console.log(contenido);
  }
}

// 4. Subclase Concreta: HTML
class GeneradorHTML extends GeneradorReporte {
  protected generarContenido(): void {
    console.log("🌐 Generando contenido en formato HTML...");
  }

  protected formatear(): string {
    let contenido = `
<html>
  <head>
    <title>Reporte HTML</title>
  </head>
  <body>
    <h1>REPORTE HTML</h1>
    <ul>
`;
    this.datos.forEach((dato) => {
      contenido += `      <li>${dato}</li>\n`;
    });
    contenido += `    </ul>
  </body>
</html>`;
    console.log("🎨 Formateando contenido como HTML");
    return contenido;
  }

  protected guardar(contenido: string): void {
    console.log("💾 Guardando como archivo.html");
    console.log(contenido);
  }
}

// 5. Cliente: Usa el patrón
class Cliente {
  crearReportes(): void {
    const datos = [
      "Venta enero: $1000",
      "Venta febrero: $1500",
      "Venta marzo: $2000",
    ];

    console.log("=== DEMOSTRACIÓN TEMPLATE METHOD PATTERN ===");

    // Generar reporte PDF
    const generadorPDF = new GeneradorPDF(datos);
    generadorPDF.generar();

    // Generar reporte Excel
    const generadorExcel = new GeneradorExcel(datos);
    generadorExcel.generar();

    // Generar reporte HTML
    const generadorHTML = new GeneradorHTML(datos);
    generadorHTML.generar();

    // Intentar generar con datos vacíos
    console.log("--- Intentando con datos vacíos ---");
    try {
      const generadorVacio = new GeneradorPDF([]);
      generadorVacio.generar();
    } catch (error) {
      console.log(error.message);
    }
  }
}

// Uso
const cliente = new Cliente();
cliente.crearReportes();
```

**Salida esperada:**
```
=== DEMOSTRACIÓN TEMPLATE METHOD PATTERN ===

📋 Iniciando generación de reporte...
✅ Datos validados correctamente
📄 Generando contenido en formato PDF...
🎨 Formateando contenido como PDF
💾 Guardando como archivo.pdf

────────────────────────────────────
REPORTE PDF
────────────────────────────────────
  1. Venta enero: $1000
  2. Venta febrero: $1500
  3. Venta marzo: $2000
────────────────────────────────────

✅ Reporte generado exitosamente

📋 Iniciando generación de reporte...
✅ Datos validados correctamente
📊 Generando contenido en formato Excel...
🎨 Formateando contenido como tabla Excel
💾 Guardando como archivo.xlsx

┌─────────────────────────────────┐
│ REPORTE EXCEL                     │
├─────────────────────────────────┤
│ # │ Contenido                    │
├─────────────────────────────────┤
│ 1 │ Venta enero: $1000          │
│ 2 │ Venta febrero: $1500        │
│ 3 │ Venta marzo: $2000          │
└─────────────────────────────────┘

✅ Reporte generado exitosamente
```

### Ventajas del Template Method Pattern

✅ Elimina código duplicado (estructura común en la clase base)
✅ Controla mediante hooks (puntos de extensión)
✅ Facilita crear nuevas variaciones
✅ Invierte el control (Hollywood Principle: "Don't call us, we'll call you")

### Desventajas

❌ Puede resultar en más métodos para implementar
❌ Las subclases quedan ligadas a la clase base
❌ Viola el principio de substitución de Liskov si se mal implementa

### Cuándo Usarlo

- Múltiples clases comparten la misma estructura de algoritmo
- Quieres evitar duplicación de código
- Necesitas permitir que subclases implementen pasos específicos
- Ejemplos: Generadores de reportes, procesadores de datos, frameworks

---

## 4. Strategy Pattern (Implementación Detallada)

### Descripción
El Strategy Pattern es un patrón de comportamiento que define una familia de algoritmos, encapsula cada uno, y los hace intercambiables. Permite que el cliente elija la estrategia en tiempo de ejecución.

### Componentes del Patrón

1. **Strategy**: Interfaz común para todas las estrategias
2. **ConcreteStrategy**: Implementaciones específicas del algoritmo
3. **Context**: Usa una estrategia sin conocer sus detalles
4. **Client**: Elige y asigna la estrategia al contexto

### Diagrama UML

```
┌──────────────────────────────┐
│  EstrategiaMetodoPago        │
│    <<interface>>             │
├──────────────────────────────┤
│ +procesar(monto: number)     │
│ +obtenerNombre(): string     │
└────────────────┬─────────────┘
                 △
                 │
    ┌────────────┼────────────┐
    │            │            │
┌───┴──────────┐ │ ┌──────────┴──┐ ┌───────────┴───┐
│PagoTarjeta   │ │ │ PagoPayPal   │ │ PagoCripto    │
├──────────────┤ │ ├──────────────┤ ├───────────────┤
│-numeroTarj   │ │ │-email        │ │-direccion     │
├──────────────┤ │ ├──────────────┤ ├───────────────┤
│+procesar()   │ │ │+procesar()   │ │+procesar()    │
│+obtenerNom() │ │ │+obtenerNom() │ │+obtenerNom()  │
└──────────────┘ │ └──────────────┘ └───────────────┘
                 │
                 ▼
          ┌──────────────────┐
          │    Carrito       │
          ├──────────────────┤
          │-estrategia: *    │
          │-total: number    │
          ├──────────────────┤
          │+pagar()          │
          │+cambiarMetodo()  │
          └────────┬─────────┘
                   │
                   ▼
            ┌──────────────┐
            │   Cliente    │
            ├──────────────┤
            │+comprar()    │
            └──────────────┘

El cliente NO está amarrado a una estrategia específica,
puede cambiarla en tiempo de ejecución.
```

### Ejemplo: Sistema de Métodos de Pago

```typescript
// 1. Interfaz Strategy: Define el contrato común
interface EstrategiaMetodoPago {
  procesar(monto: number): void;
  obtenerNombre(): string;
}

// 2. ConcreteStrategy: Pago con Tarjeta
class PagoTarjeta implements EstrategiaMetodoPago {
  private numeroTarjeta: string;
  private cvv: string;

  constructor(numeroTarjeta: string, cvv: string) {
    this.numeroTarjeta = numeroTarjeta;
    this.cvv = cvv;
  }

  procesar(monto: number): void {
    console.log(
      `💳 Procesando pago con Tarjeta: ${this.numeroTarjeta.slice(-4)}`
    );
    console.log(`   Monto: $${monto.toFixed(2)}`);
    console.log(`   ✅ Pago completado exitosamente`);
  }

  obtenerNombre(): string {
    return "Tarjeta de Crédito";
  }
}

// 3. ConcreteStrategy: Pago con PayPal
class PagoPayPal implements EstrategiaMetodoPago {
  private email: string;
  private contraseña: string;

  constructor(email: string, contraseña: string) {
    this.email = email;
    this.contraseña = contraseña;
  }

  procesar(monto: number): void {
    console.log(`🅿️ Procesando pago con PayPal: ${this.email}`);
    console.log(`   Monto: $${monto.toFixed(2)}`);
    console.log(`   ✅ Transacción autorizada`);
    console.log(`   ✅ Pago completado exitosamente`);
  }

  obtenerNombre(): string {
    return "PayPal";
  }
}

// 4. ConcreteStrategy: Pago con Criptomoneda
class PagoCripto implements EstrategiaMetodoPago {
  private direccion: string;
  private moneda: string;

  constructor(direccion: string, moneda: string = "BTC") {
    this.direccion = direccion;
    this.moneda = moneda;
  }

  procesar(monto: number): void {
    const valorCripto = (monto / 25000).toFixed(8); // Conversión ficticia
    console.log(
      `🪙 Procesando pago con ${this.moneda}: ${this.direccion.slice(-6)}`
    );
    console.log(`   Monto: $${monto.toFixed(2)}`);
    console.log(`   Equivalente: ${valorCripto} ${this.moneda}`);
    console.log(`   ✅ Transacción enviada a blockchain`);
    console.log(`   ✅ Pago completado exitosamente`);
  }

  obtenerNombre(): string {
    return `Criptomoneda (${this.moneda})`;
  }
}

// 5. Context: Carrito que usa la estrategia
class Carrito {
  private estrategia: EstrategiaMetodoPago | null = null;
  private total: number;
  private articulos: string[] = [];

  constructor(total: number) {
    this.total = total;
  }

  establecerMetodoPago(estrategia: EstrategiaMetodoPago): void {
    this.estrategia = estrategia;
    console.log(
      `\n🛒 Método de pago seleccionado: ${estrategia.obtenerNombre()}`
    );
  }

  agregarArticulo(articulo: string): void {
    this.articulos.push(articulo);
  }

  mostrarCarrito(): void {
    console.log("\n📦 Contenido del carrito:");
    this.articulos.forEach((articulo, index) => {
      console.log(`   ${index + 1}. ${articulo}`);
    });
    console.log(`📊 Total: $${this.total.toFixed(2)}`);
  }

  pagar(): void {
    if (!this.estrategia) {
      console.log("❌ Error: Debe seleccionar un método de pago");
      return;
    }

    this.mostrarCarrito();
    console.log("\n--- Procesando pago ---");
    this.estrategia.procesar(this.total);
  }

  cambiarMetodoPago(estrategia: EstrategiaMetodoPago): void {
    console.log(
      `\n🔄 Cambiando método de pago a: ${estrategia.obtenerNombre()}`
    );
    this.estrategia = estrategia;
  }
}

// 6. Cliente: Utiliza el carrito
class Cliente {
  comprar(): void {
    console.log("=== DEMOSTRACIÓN STRATEGY PATTERN ===");
    console.log("Sistema de Métodos de Pago Intercambiables\n");

    // Crear carrito
    const carrito = new Carrito(250.5);
    carrito.agregarArticulo("Laptop");
    carrito.agregarArticulo("Mouse");
    carrito.agregarArticulo("Teclado");

    // --- Compra 1: Con Tarjeta ---
    console.log("\n--- COMPRA 1: Pago con Tarjeta ---");
    carrito.establecerMetodoPago(new PagoTarjeta("4532123456789012", "123"));
    carrito.pagar();

    // --- Compra 2: Cambiar a PayPal ---
    console.log("\n--- COMPRA 2: Cambiar a PayPal ---");
    carrito.cambiarMetodoPago(new PagoPayPal("usuario@example.com", "pass123"));
    carrito.pagar();

    // --- Compra 3: Cambiar a Criptomoneda ---
    console.log("\n--- COMPRA 3: Cambiar a Criptomoneda (Ethereum) ---");
    carrito.cambiarMetodoPago(
      new PagoCripto("0x1234567890abcdef", "ETH")
    );
    carrito.pagar();

    // --- Compra 4: Sin estrategia ---
    console.log("\n--- COMPRA 4: Intento sin métodode pago ---");
    const carritoSinMetodo = new Carrito(100);
    carritoSinMetodo.agregarArticulo("Producto");
    carritoSinMetodo.pagar();
  }
}

// Uso
const cliente = new Cliente();
cliente.comprar();
```

**Salida esperada:**
```
=== DEMOSTRACIÓN STRATEGY PATTERN ===
Sistema de Métodos de Pago Intercambiables

🛒 Método de pago seleccionado: Tarjeta de Crédito

--- COMPRA 1: Pago con Tarjeta ---
📦 Contenido del carrito:
   1. Laptop
   2. Mouse
   3. Teclado
📊 Total: $250.50

--- Procesando pago ---
💳 Procesando pago con Tarjeta: 9012
   Monto: $250.50
   ✅ Pago completado exitosamente

🛒 Método de pago seleccionado: PayPal
🔄 Cambiando método de pago a: PayPal

--- COMPRA 2: Cambio a PayPal ---
📦 Contenido del carrito:
   1. Laptop
   2. Mouse
   3. Teclado
📊 Total: $250.50

--- Procesando pago ---
🅿️ Procesando pago con PayPal: usuario@example.com
   Monto: $250.50
   ✅ Transacción autorizada
   ✅ Pago completado exitosamente

🛒 Método de pago seleccionado: Criptomoneda (ETH)
🔄 Cambiando método de pago a: Criptomoneda (ETH)

--- COMPRA 3: Cambio a Criptomoneda (Ethereum) ---
...
```

### Ventajas del Strategy Pattern

✅ Permite cambiar algoritmos en tiempo de ejecución
✅ Elimina condicionales largos (if/else o switch)
✅ Fácil agregar nuevas estrategias sin modificar código existente
✅ Sigue el principio Open/Closed (abierto para extensión, cerrado para modificación)
✅ Separa la lógica del algoritmo del contexto

### Desventajas

❌ Aumenta el número de clases
❌ Puede ser excesivo si solo hay una o dos estrategias
❌ El cliente debe conocer todas las estrategias disponibles

### Cuándo Usarlo

- Múltiples clases difieren solo en cómo ejecutan un algoritmo
- Necesitas cambiar de algoritmo en tiempo de ejecución
- Quieres evitar condicionales grandes (if/else)
- Tienes diferentes variantes de un proceso (ej: múltiples métodos de pago)
- Ejemplos: Métodos de pago, procesamiento de datos, algoritmos de ordenamiento, estrategias de compresión

---

## 5. Adapter Pattern

### Descripción
El Adapter Pattern es un patrón estructural que permite que clases con interfaces incompatibles trabajen juntas. Actúa como puente entre dos interfaces diferentes.

### Componentes del Patrón

1. **Target**: Interfaz que el cliente espera usar
2. **Adaptee**: Clase existente con una interfaz diferente
3. **Adapter**: Clase que adapta Adaptee a Target
4. **Client**: Usa la interfaz Target

### Diagrama UML

```
┌─────────────┐
│   Cliente   │
│ +procesar() │
└──────┬──────┘
       │ usa
       ▼
┌──────────────────┐
│    Target        │
│  <<interface>>   │
│  +convertir()    │
└────────┬─────────┘
         ▲
         │ implementa
         │
    ┌────┴──────────────┐
    │   Adaptador       │
    │ -adaptee:Adaptee  │
    │ +convertir()      │
    └────┬──────────────┘
         │
         │ envuelve
         ▼
    ┌─────────────┐
    │  Adaptee    │
    │ +traducir() │
    └─────────────┘
```

### Ejemplo de Implementación

```typescript
// 1. Interfaz Target (lo que el cliente espera)
interface Convertidor {
  convertir(): string;
}

// 2. Clase Adaptee (clase existente con interfaz incompatible)
class TraductorViejo {
  traducir(): string {
    return "Contenido traducido";
  }
}

// 3. Adaptador (adapta Adaptee para que implemente Target)
class AdaptadorTraductor implements Convertidor {
  private adaptee: TraductorViejo;

  constructor(adaptee: TraductorViejo) {
    this.adaptee = adaptee;
  }

  convertir(): string {
    // Adapta el método traducir() al método convertir()
    return this.adaptee.traducir();
  }
}

// 4. Cliente que usa Target
class Cliente {
  procesar(convertidor: Convertidor): void {
    const resultado = convertidor.convertir();
    console.log(resultado);
  }
}

// Uso
const traductorViejo = new TraductorViejo();
const adaptador = new AdaptadorTraductor(traductorViejo);
const cliente = new Cliente();
cliente.procesar(adaptador); // Funciona perfectamente
```

### Ventajas del Adapter Pattern

✅ Permite que clases incompatibles trabajen juntas
✅ No requiere modificar código existente
✅ Promueve la reutilización de código
✅ Mantiene el principio de separación de responsabilidades

### Desventajas

❌ Puede añadir complejidad si se abusa de él
❌ Puede impactar el rendimiento si hay muchas adaptaciones

### Cuándo Usarlo

- Necesitas usar una clase existente pero su interfaz no es compatible
- Quieres crear una clase reutilizable que trabaje con varias clases que tienen interfaces incompatibles
- Necesitas hacer compatible código legado con nuevo código

---

## 6. Composite Pattern

### Descripción
El Composite Pattern es un patrón estructural que permite crear estructuras jerárquicas (árboles) compostas de objetos simples y compuestos. Permite que los clientes traten los objetos individuales y las composiciones de manera uniforme.

### Componentes del Patrón

1. **Component**: Interfaz común para hojas y composites
2. **Leaf**: Objeto terminal que no tiene hijos
3. **Composite**: Objeto que puede contener hojas u otros composites
4. **Client**: Usa los objetos a través de la interfaz Component

### Diagrama UML

```
┌─────────────────────┐
│    Componente       │
│   <<interface>>     │
├─────────────────────┤
│ +nombre: string     │
│ +tamaño(): int      │
│ +obtenerNombre()    │
│ +mostrar()          │
└──────────┬──────────┘
           △
           │
      ┌────┴─────────┐
      │              │
      │              │
  ┌───┴────────┐   ┌┴──────────────┐
  │   Archivo  │   │   Carpeta     │
  │  (Leaf)    │   │  (Composite)  │
  ├────────────┤   ├───────────────┤
  │-nombre     │   │-nombre        │
  │-tamaño     │   │-componentes[] │
  ├────────────┤   ├───────────────┤
  │+mostrar()  │   │+agregar()     │
  │+tamaño()   │   │+remover()     │
  └────────────┘   │+mostrar()     │
                   │+tamaño()      │
                   └───────────────┘
                         △
                         │ contiene
                         │
                    ┌────┴──────────┐
                    │  FileSystem   │
                    ├───────────────┤
                    │-raiz:Carpeta  │
                    ├───────────────┤
                    │+crear()       │
                    │+mostrar()     │
                    └───────────────┘
```

### Ejemplo: FileSystem

```typescript
// 1. Interfaz Component (común para Archivo y Carpeta)
interface Componente {
  nombre: string;
  tamaño(): number;
  obtenerNombre(): string;
  mostrar(): void;
}

// 2. Leaf: Archivo (no contiene elementos)
class Archivo implements Componente {
  nombre: string;
  private tamaño_: number;

  constructor(nombre: string, tamaño: number) {
    this.nombre = nombre;
    this.tamaño_ = tamaño;
  }

  tamaño(): number {
    return this.tamaño_;
  }

  obtenerNombre(): string {
    return this.nombre;
  }

  mostrar(): void {
    console.log(`📄 ${this.nombre} (${this.tamaño_} KB)`);
  }
}

// 3. Composite: Carpeta (puede contener archivos o carpetas)
class Carpeta implements Componente {
  nombre: string;
  private componentes: Componente[] = [];

  constructor(nombre: string) {
    this.nombre = nombre;
  }

  agregarComponente(componente: Componente): void {
    this.componentes.push(componente);
  }

  removerComponente(componente: Componente): void {
    const indice = this.componentes.indexOf(componente);
    if (indice > -1) {
      this.componentes.splice(indice, 1);
    }
  }

  tamaño(): number {
    return this.componentes.reduce(
      (total, componente) => total + componente.tamaño(),
      0
    );
  }

  obtenerNombre(): string {
    return this.nombre;
  }

  obtenerComponentes(): Componente[] {
    return this.componentes;
  }

  mostrar(indentacion: string = ""): void {
    console.log(`📁 ${indentacion}${this.nombre}/ (${this.tamaño()} KB)`);
    this.componentes.forEach((componente) => {
      if (componente instanceof Carpeta) {
        componente.mostrar(indentacion + "  ");
      } else {
        console.log(`${indentacion}  `, componente);
        componente.mostrar();
      }
    });
  }
}

// 4. FileSystem: Cliente que usa el patrón
class FileSystem {
  private raiz: Carpeta;

  constructor() {
    this.raiz = new Carpeta("raiz");
  }

  crear(): void {
    // Crear estructura
    const documentos = new Carpeta("Documentos");
    const imagenes = new Carpeta("Imágenes");
    const descarga = new Carpeta("Descargas");

    // Agregar archivos a Documentos
    documentos.agregarComponente(new Archivo("reporte.pdf", 250));
    documentos.agregarComponente(new Archivo("presupuesto.xlsx", 150));

    // Crear subcarpeta en Imágenes
    const fotos = new Carpeta("Fotos");
    fotos.agregarComponente(new Archivo("foto1.jpg", 2000));
    fotos.agregarComponente(new Archivo("foto2.jpg", 1800));
    imagenes.agregarComponente(fotos);

    // Agregar a descarga
    descarga.agregarComponente(new Archivo("instalador.exe", 500000));

    // Agregar todo a la raiz
    this.raiz.agregarComponente(documentos);
    this.raiz.agregarComponente(imagenes);
    this.raiz.agregarComponente(descarga);
  }

  mostrarEstructura(): void {
    console.log("=== Estructura del Sistema de Archivos ===");
    this.raiz.mostrar();
    console.log(`\nTamaño total: ${this.raiz.tamaño()} KB`);
  }
}

// Uso
const fileSystem = new FileSystem();
fileSystem.crear();
fileSystem.mostrarEstructura();
```

**Salida esperada:**
```
=== Estructura del Sistema de Archivos ===
📁 raiz/ (507800 KB)
  📁   Documentos/ (400 KB)
    📄 reporte.pdf (250 KB)
    📄 presupuesto.xlsx (150 KB)
  📁   Imágenes/ (3800 KB)
    📁   Fotos/ (3800 KB)
      📄 foto1.jpg (2000 KB)
      📄 foto2.jpg (1800 KB)
  📁   Descargas/ (500000 KB)
    📄 instalador.exe (500000 KB)

Tamaño total: 507800 KB
```

### Ventajas del Composite Pattern

✅ Trata objetos individuales y composiciones uniformemente
✅ Facilita crear nuevos tipos de componentes
✅ Simplifica el código cliente (no necesita saber si es hoja o composite)
✅ Permite crear estructuras jerárquicas complejas

### Desventajas

❌ Puede resultar en diseños genéricos que son difíciles de entender
❌ No es eficiente si la jerarquía es muy profunda

### Cuándo Usarlo

- Necesitas representar jerarquías parte-todo (árboles)
- Quieres que el cliente trate objetos individuales y composiciones de manera uniforme
- Estructura de carpetas/archivos, menús con submenús, árbol DOM, etc.

---

## 7. Proxy Pattern

### Descripción
El Proxy Pattern es un patrón estructural que proporciona un sustituto o marcador de posición para otro objeto. El proxy controla el acceso al objeto real, permitiendo realizar acciones adicionales antes o después de acceder al objeto (autenticación, validación, caché, logging, etc).

### Componentes del Patrón

1. **Subject**: Interfaz común para el objeto real y el proxy
2. **RealSubject**: Objeto real cuyo acceso se controla
3. **Proxy**: Sustituto que controla el acceso al objeto real
4. **Client**: Usa el proxy sin conocer que es un sustituto

### Diagrama UML

```
┌──────────────────────┐
│   DataBaseAccess     │
│   <<interface>>      │
├──────────────────────┤
│ +insertar(dato)      │
│ +obtener(id)         │
└────────────┬─────────┘
             △
             │
    ┌────────┴──────────┐
    │                   │
┌───┴──────────────┐   ┌┴───────────────────┐
│   BaseDatos      │   │ ProxyBaseDatos     │
├──────────────────┤   ├────────────────────┤
│-storage: Map     │   │-usuario: string    │
├──────────────────┤   │-contraseña: string │
│+insertar()       │   │-autenticado: bool  │
│+obtener()        │   │-baseDatos: DB     │
└──────────────────┘   ├────────────────────┤
                       │+login()            │
                       │+insertar()         │
                       │+obtener()          │
                       │-verificarAuth()    │
                       └─────────┬──────────┘
                                 │ accede si
                                 │ autenticado
                                 ▼
                          ┌──────────────────┐
                          │  Cliente         │
                          │ -db: DBAccess    │
                          ├──────────────────┤
                          │+operaciones()    │
                          └──────────────────┘
```

### Ejemplo: Acceso Seguro a Base de Datos

```typescript
// 1. Interfaz Subject: Define el contrato común
interface DataBaseAccess {
  insertar(dato: string): void;
  obtener(id: string): string;
}

// 2. RealSubject: Base de datos real
class BaseDatos implements DataBaseAccess {
  private storage: Map<string, string> = new Map();
  private contador: number = 0;

  insertar(dato: string): void {
    const id = `ID_${++this.contador}`;
    this.storage.set(id, dato);
    console.log(`✅ [BaseDatos] Dato insertado: ${id} = "${dato}"`);
  }

  obtener(id: string): string {
    const dato = this.storage.get(id);
    if (dato) {
      console.log(`✅ [BaseDatos] Dato obtenido: ${id} = "${dato}"`);
      return dato;
    }
    console.log(`❌ [BaseDatos] Dato no encontrado: ${id}`);
    return "";
  }

  mostrarTodos(): void {
    console.log("\n📋 Contenido de la Base de Datos:");
    this.storage.forEach((valor, clave) => {
      console.log(`   ${clave}: ${valor}`);
    });
  }
}

// 3. Proxy: Controla el acceso a la base de datos
class ProxyBaseDatos implements DataBaseAccess {
  private usuario: string = "";
  private contraseña: string = "";
  private autenticado: boolean = false;
  private baseDatos: BaseDatos;
  private usuarioValido: string = "admin";
  private contraseñaValida: string = "1234";

  constructor() {
    this.baseDatos = new BaseDatos();
  }

  // Método para iniciar sesión
  login(usuario: string, contraseña: string): boolean {
    if (usuario === this.usuarioValido && contraseña === this.contraseñaValida) {
      this.usuario = usuario;
      this.contraseña = contraseña;
      this.autenticado = true;
      console.log(`🔓 [Proxy] Sesión iniciada como: ${usuario}\n`);
      return true;
    } else {
      console.log(`🔒 [Proxy] Credenciales inválidas\n`);
      this.autenticado = false;
      return false;
    }
  }

  // Método para cerrar sesión
  logout(): void {
    this.autenticado = false;
    this.usuario = "";
    console.log(`🔒 [Proxy] Sesión cerrada\n`);
  }

  // Método privado para verificar autenticación
  private verificarAutenticacion(): boolean {
    if (!this.autenticado) {
      console.log(
        `🚫 [Proxy] Acceso denegado. Debe iniciar sesión primero.\n`
      );
      return false;
    }
    return true;
  }

  // Implementa el método insertar con control de acceso
  insertar(dato: string): void {
    console.log(
      `[Proxy] Intento de inserción por usuario: ${this.usuario || "anónimo"}`
    );
    if (this.verificarAutenticacion()) {
      console.log(`[Proxy] Verificación exitosa. Delegando a BaseDatos...\n`);
      this.baseDatos.insertar(dato);
    }
  }

  // Implementa el método obtener con control de acceso
  obtener(id: string): string {
    console.log(
      `[Proxy] Intento de lectura por usuario: ${this.usuario || "anónimo"}`
    );
    if (this.verificarAutenticacion()) {
      console.log(`[Proxy] Verificación exitosa. Delegando a BaseDatos...\n`);
      return this.baseDatos.obtener(id);
    }
    return "";
  }

  mostrarTodos(): void {
    if (this.verificarAutenticacion()) {
      this.baseDatos.mostrarTodos();
    }
  }
}

// 4. Cliente: Usa el proxy sin saber que es un sustituto
class Cliente {
  private db: DataBaseAccess;

  constructor(db: DataBaseAccess) {
    this.db = db;
  }

  operaciones(): void {
    // Intentar insertar sin autenticación
    console.log("--- Intento 1: Insertar SIN autenticación ---");
    this.db.insertar("Datos secretos");

    // Intentar obtener sin autenticación
    console.log("\n--- Intento 2: Obtener SIN autenticación ---");
    this.db.obtener("ID_1");
  }
}

// Uso
console.log("=== DEMOSTRACIÓN DEL PROXY PATTERN ===\n");

const proxy = new ProxyBaseDatos();
const cliente = new Cliente(proxy);

// Intentos sin autenticación
cliente.operaciones();

// Autenticarse
console.log("--- Autenticación ---");
proxy.login("admin", "1234");

// Insertar datos
console.log("--- Intento 3: Insertar CON autenticación ---");
proxy.insertar("Usuario autenticado");
proxy.insertar("Más datos");

// Obtener datos
console.log("--- Intento 4: Obtener CON autenticación ---");
proxy.obtener("ID_1");

// Ver todos los datos
console.log("--- Intento 5: Ver todos los datos ---");
(proxy as any).mostrarTodos();

// Intentar con credenciales inválidas
console.log("\n--- Intento 6: Login con credenciales inválidas ---");
proxy.logout();
proxy.login("usuario", "contraseña");
proxy.insertar("No debería funcionar");
```

**Salida esperada:**
```
=== DEMOSTRACIÓN DEL PROXY PATTERN ===

--- Intento 1: Insertar SIN autenticación ---
[Proxy] Intento de inserción por usuario: anónimo
🚫 [Proxy] Acceso denegado. Debe iniciar sesión primero.

--- Intento 2: Obtener SIN autenticación ---
[Proxy] Intento de lectura por usuario: anónimo
🚫 [Proxy] Acceso denegado. Debe iniciar sesión primero.

--- Autenticación ---
🔓 [Proxy] Sesión iniciada como: admin

--- Intento 3: Insertar CON autenticación ---
[Proxy] Intento de inserción por usuario: admin
[Proxy] Verificación exitosa. Delegando a BaseDatos...
✅ [BaseDatos] Dato insertado: ID_1 = "Usuario autenticado"
✅ [BaseDatos] Dato insertado: ID_2 = "Más datos"

--- Intento 4: Obtener CON autenticación ---
[Proxy] Intento de lectura por usuario: admin
[Proxy] Verificación exitosa. Delegando a BaseDatos...
✅ [BaseDatos] Dato obtenido: ID_1 = "Usuario autenticado"

--- Intento 5: Ver todos los datos ---
📋 Contenido de la Base de Datos:
   ID_1: Usuario autenticado
   ID_2: Más datos
```

### Ventajas del Proxy Pattern

✅ Control de acceso a objetos sensibles
✅ Lazy initialization (crear objeto solo cuando se necesita)
✅ Logging y auditoría de accesos
✅ Caché de datos frecuentes
✅ Desvincula al cliente de la implementación real

### Desventajas

❌ Puede añadir latencia si el proxy es complejo
❌ Aumenta la complejidad del código
❌ El proxy debe mantener la misma interfaz (rígido)

### Cuándo Usarlo

- Control de acceso (autenticación, autorización)
- Lazy initialization (cargar recursos solo cuando se necesiten)
- Logging y auditoría de operaciones
- Caché de resultados
- Validación de parámetros
- Acceso a recursos remotos

---

## 8. Decorator Pattern (Implementación Detallada)

### Descripción
El Decorator Pattern es un patrón estructural que permite agregar funcionalidad a objetos de forma dinámica, sin alterar su estructura. Proporciona una alternativa flexible a la herencia para extender funcionalidad. Los decoradores se pueden adaptar en tiempo de ejecución a diferencia de la herencia estática.

### Componentes del Patrón

1. **Component**: Interfaz que define el objeto que puede ser decorado
2. **ConcreteComponent**: Objeto base que será decorado
3. **Decorator**: Clase abstracta que envuelve un componente
4. **ConcreteDecorator**: Añade responsabilidades específicas al componente
5. **Client**: Usa componentes y decoradores

### Diagrama UML

```
┌──────────────────────────┐
│    Componente            │
│   <<interface>>          │
├──────────────────────────┤
│ +obtenerDescripcion()    │
│ +obtenerPrecio(): number │
└────────────┬─────────────┘
             △
             │
    ┌────────┴──────────────┐
    │                       │
┌───┴──────────────┐  ┌────┴──────────────┐
│   BebidaBase     │  │  DecoradorBebida │
├──────────────────┤  │   <<abstract>>   │
│-nombre: string   │  ├──────────────────┤
│-precio: number   │  │-componente:Comp  │
├──────────────────┤  ├──────────────────┤
│+obtenerDesc()    │  │+obtenerDesc()    │
│+obtenerPrecio()  │  │+obtenerPrecio()  │
└──────────────────┘  └────┬─────────────┘
                            △
                            │
             ┌──────────────┼──────────────┐
             │              │              │
       ┌─────┴────┐   ┌─────┴─────┐  ┌────┴──────┐
       │Leche     │   │Chocolate  │  │ Caramelo  │
       ├──────────┤   ├───────────┤  ├───────────┤
       │+obtener()│   │+obtener() │  │+obtener() │
       │+precio() │   │+precio()  │  │+precio()  │
       └──────────┘   └───────────┘  └───────────┘

Los decoradores pueden combinarse:
Café → Leche → Chocolate → Caramelo
```

### Ejemplo: Sistema de Bebidas de Café

```typescript
// 1. Interfaz Component: Define el contrato
interface Componente {
  obtenerDescripcion(): string;
  obtenerPrecio(): number;
}

// 2. ConcreteComponent: Bebida base
class BebidaBase implements Componente {
  private nombre: string;
  private precio: number;

  constructor(nombre: string, precio: number) {
    this.nombre = nombre;
    this.precio = precio;
  }

  obtenerDescripcion(): string {
    return this.nombre;
  }

  obtenerPrecio(): number {
    return this.precio;
  }
}

// 3. Decorator Abstracto: Base para todos los decoradores
abstract class DecoradorBebida implements Componente {
  protected componenteBase: Componente;

  constructor(componente: Componente) {
    this.componenteBase = componente;
  }

  obtenerDescripcion(): string {
    return this.componenteBase.obtenerDescripcion();
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio();
  }
}

// 4. ConcreteDecorator: Leche
class DecoradorLeche extends DecoradorBebida {
  obtenerDescripcion(): string {
    return `${this.componenteBase.obtenerDescripcion()} + Leche`;
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio() + 0.5;
  }
}

// 5. ConcreteDecorator: Chocolate
class DecoradorChocolate extends DecoradorBebida {
  obtenerDescripcion(): string {
    return `${this.componenteBase.obtenerDescripcion()} + Chocolate`;
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio() + 0.75;
  }
}

// 6. ConcreteDecorator: Caramelo
class DecoradorCaramelo extends DecoradorBebida {
  obtenerDescripcion(): string {
    return `${this.componenteBase.obtenerDescripcion()} + Caramelo`;
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio() + 0.6;
  }
}

// 7. ConcreteDecorator: Canela
class DecoradorCanela extends DecoradorBebida {
  obtenerDescripcion(): string {
    return `${this.componenteBase.obtenerDescripcion()} + Canela`;
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio() + 0.4;
  }
}

// 8. ConcreteDecorator: Crema Batida
class DecoradorCremaB extends DecoradorBebida {
  obtenerDescripcion(): string {
    return `${this.componenteBase.obtenerDescripcion()} + Crema Batida`;
  }

  obtenerPrecio(): number {
    return this.componenteBase.obtenerPrecio() + 0.9;
  }
}

// 9. Cliente: Crea bebidas con diferentes decoraciones
class CafeLatte {
  crear(): void {
    console.log("=== DEMOSTRACIÓN DECORATOR PATTERN ===");
    console.log("Sistema de Bebidas de Café\n");

    // Bebida 1: Café simple
    console.log("--- Bebida 1: Café Espresso Simple ---");
    let bebida: Componente = new BebidaBase("Café Espresso", 2.5);
    this.mostrarBebida(bebida);

    // Bebida 2: Café con leche
    console.log("\n--- Bebida 2: Café con Leche ---");
    bebida = new BebidaBase("Café Espresso", 2.5);
    bebida = new DecoradorLeche(bebida);
    this.mostrarBebida(bebida);

    // Bebida 3: Café con leche y chocolate
    console.log("\n--- Bebida 3: Café con Leche y Chocolate ---");
    bebida = new BebidaBase("Café Espresso", 2.5);
    bebida = new DecoradorLeche(bebida);
    bebida = new DecoradorChocolate(bebida);
    this.mostrarBebida(bebida);

    // Bebida 4: Café con múltiples decoraciones
    console.log("\n--- Bebida 4: Café Gourmet (Leche + Chocolate + Caramelo + Crema) ---");
    bebida = new BebidaBase("Café Espresso", 2.5);
    bebida = new DecoradorLeche(bebida);
    bebida = new DecoradorChocolate(bebida);
    bebida = new DecoradorCaramelo(bebida);
    bebida = new DecoradorCremaB(bebida);
    this.mostrarBebida(bebida);

    // Bebida 5: Café con canela
    console.log("\n--- Bebida 5: Café con Canela ---");
    bebida = new BebidaBase("Café Americano", 2.0);
    bebida = new DecoradorCanela(bebida);
    this.mostrarBebida(bebida);

    // Bebida 6: Combinación especial
    console.log("\n--- Bebida 6: Café Especial del Día ---");
    bebida = new BebidaBase("Café Lungo", 3.0);
    bebida = new DecoradorLeche(bebida);
    bebida = new DecoradorCanela(bebida);
    bebida = new DecoradorCremaB(bebida);
    this.mostrarBebida(bebida);

    // Comparativa de precios
    console.log("\n--- Comparativa de Precios ---");
    const bebidaSimple = new BebidaBase("Espresso", 2.5);
    const bebidaDecorada = new DecoradorLeche(
      new DecoradorChocolate(
        new DecoradorCaramelo(
          new DecoradorCremaB(new BebidaBase("Espresso", 2.5))
        )
      )
    );

    console.log(`Espresso Simple: $${bebidaSimple.obtenerPrecio().toFixed(2)}`);
    console.log(`Espresso Decorado: $${bebidaDecorada.obtenerPrecio().toFixed(2)}`);
    const diferencia = bebidaDecorada.obtenerPrecio() - bebidaSimple.obtenerPrecio();
    console.log(`Diferencia de precio: $${diferencia.toFixed(2)}`);
  }

  private mostrarBebida(bebida: Componente): void {
    const descripcion = bebida.obtenerDescripcion();
    const precio = bebida.obtenerPrecio().toFixed(2);
    console.log(`  ☕ ${descripcion}`);
    console.log(`  💰 Precio: $${precio}`);
  }
}

// Uso
const cafe = new CafeLatte();
cafe.crear();
```

**Salida esperada:**
```
=== DEMOSTRACIÓN DECORATOR PATTERN ===
Sistema de Bebidas de Café

--- Bebida 1: Café Espresso Simple ---
  ☕ Café Espresso
  💰 Precio: $2.50

--- Bebida 2: Café con Leche ---
  ☕ Café Espresso + Leche
  💰 Precio: $3.00

--- Bebida 3: Café con Leche y Chocolate ---
  ☕ Café Espresso + Leche + Chocolate
  💰 Precio: $3.75

--- Bebida 4: Café Gourmet (Leche + Chocolate + Caramelo + Crema) ---
  ☕ Café Espresso + Leche + Chocolate + Caramelo + Crema Batida
  💰 Precio: $5.75

--- Bebida 5: Café con Canela ---
  ☕ Café Americano + Canela
  💰 Precio: $2.40

--- Bebida 6: Café Especial del Día ---
  ☕ Café Lungo + Leche + Canela + Crema Batida
  💰 Precio: $5.40

--- Comparativa de Precios ---
Espresso Simple: $2.50
Espresso Decorado: $5.75
Diferencia de precio: $3.25
```

### Ventajas del Decorator Pattern

✅ Más flexible que la herencia
✅ Permite combinar decoradores de múltiples formas
✅ Responsabilidad única (cada decorador hace una cosa)
✅ Fácil agregar nuevas funcionalidades sin modificar código existente
✅ Permite agregar/remover funcionalidades en tiempo de ejecución

### Desventajas

❌ Muchos decoradores pueden crear código complejo
❌ El orden de los decoradores importa (impacta el resultado)
❌ Difícil de debuguear si hay muchas capas de decoradores

### Cuándo Usarlo

- Necesitas agregar responsabilidades a objetos de forma dinámica
- Quieres evitar una jerarquía de clases explosiva
- Necesitas combinar features de múltiples formas
- Ejemplos: Sistemas de bebidas, UI components con features, procesamiento de streams

---

## Resumen

1. **Template Method**: Herencia, estructura fija, pasos variables
2. **Strategy**: Composición, comportamiento intercambiable en tiempo de ejecución
3. **State**: Composición, comportamiento según estado
4. **Adapter**: Adapta interfaces incompatibles
5. **Composite**: Estructuras jerárquicas
6. **Proxy**: Controla acceso mediante autenticación/validación
7. **Decorator**: Agrega funcionalidad dinámicamente sin herencia

### Patrones Implementados Detalladamente

- **Sección 2: State Pattern** - Reproductor de Música con máquina de estados
- **Sección 3: Template Method** - Generador de Reportes (PDF, Excel, HTML)
- **Sección 4: Strategy** - Sistema de Métodos de Pago (Tarjeta, PayPal, Cripto)
- **Sección 8: Decorator** - Sistema de Bebidas de Café con añadidos dinámicos

---

*Documento creado el 7 de marzo de 2026*
*Para estudio y repaso de patrones de diseño en TypeScript*
