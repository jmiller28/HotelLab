package hotel.lab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author John
 */
public interface IHotelDAO {

    List<Hotel> getAllHotels() throws Exception;
    
    void save(Hotel hotel) throws SQLException, Exception;
    
    void deleteHotel(String tableName, String whereField, Object whereValue) 
            throws SQLException;
}
