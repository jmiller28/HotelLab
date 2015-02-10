package hotel.lab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author John
 */
public interface IHotelDAO {

    List<Hotel> getAllHotels() throws Exception;
    
    void saveHotels(Hotel hotel) throws SQLException, Exception;
    
    void deleteHotels(String tableName, String whereField, Object whereValue) 
            throws SQLException;
}
