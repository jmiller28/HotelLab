package hotel.lab;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    //not complete
    public final Map getHotelById(String tableName, String primaryKeyField,
            Object keyValue) throws SQLException {

        return null;
    }

    public final void deleteHotels(String tableName, String whereField,
            Object whereValue) throws SQLException {
        hotelDAO.deleteHotels(tableName, whereField, whereValue);
    }

    public final void saveHotel(Hotel hotel) throws SQLException, Exception {
        hotelDAO.saveHotels(hotel);
    }

    public static void main(String[] args) throws Exception {
        HotelService hotelService = new HotelService();

//        Hotel hotel = new Hotel("John's Hotel","","","","","");       
//        hotelService.save(hotel);
        System.out.println(hotelService.getAllHotels());

//        hotelService.deleteHotel("hotel", "hotel_name", "Test");
    }
}
