package hotel.lab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author John
 */
public class HotelService {

    private IHotelDAO hotelDAO;
    private static IDB_MySql db;

    public HotelService() {
        db = new DB_MySql();
        hotelDAO = new HotelDAO((DB_MySql) db);
    }

    public final List<Hotel> getAllHotels() throws Exception {
        return hotelDAO.getAllHotels();
    }

    public final void save(Hotel hotel) throws SQLException, Exception {   
        hotelDAO.save(hotel);
    }
    
    public final void deleteHotel(String tableName, String whereField,
            Object whereValue) throws SQLException {
        hotelDAO.deleteHotel(tableName, whereField, whereValue);
    }
    public static void main(String[] args) throws Exception {
        HotelService hotelService = new HotelService();
        
//        Hotel hotel = new Hotel("John's Hotel","","","","","");       
//        hotelService.save(hotel);
        
        System.out.println(hotelService.getAllHotels());
        
//        hotelService.deleteHotel("hotel", "hotel_name", "Test");
    }
}
