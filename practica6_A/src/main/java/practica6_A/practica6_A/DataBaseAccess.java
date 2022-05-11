package practica6_A.practica6_A;


import java.util.Collection;
import java.util.List;

public interface DataBaseAccess {
    Collection<String> getSearchResults(String queryString);

    int insertNewRow(List<String> rowData);
}