package hotel.lab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public class HotelDAO implements IHotelDAO {

    private static final String FIND_ALL_HOTELS = "hotel";
    private DB_MySql db;
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String userName = "admin";
    private String password = "admin";

    public HotelDAO(DB_MySql db) {
        this.db = db;
    }

    private void openConnection() throws ClassNotFoundException, SQLException {
        db.openConnection(driverClassName, url, userName, password);
    }

    @Override
    public List<Hotel> getAllHotels() throws Exception {

        List<Map<String, Object>> rawData = new ArrayList<>();
        List<Hotel> records = new ArrayList<>();
        HotelDAO dao = new HotelDAO(new DB_MySql());

        try {
            dao.openConnection();
            rawData = db.getAllRecords(FIND_ALL_HOTELS);
            Hotel hotel = null;

            for (Map m : rawData) {
                hotel = new Hotel();
                String id = m.get("hotel_id").toString();
                hotel.setHotelId(new Long(id));
                String hotelName = m.get("hotel_name").toString();
                hotel.setHotelName(hotelName);
                String streetAddress = m.get("street_address").toString();
                hotel.setStreetAddress(streetAddress);
                String city = m.get("city").toString();
                hotel.setCity(city);
                String state = m.get("state").toString();
                hotel.setState(state);
                String postalCode = m.get("postal_code").toString();
                hotel.setPostalCode(postalCode);
                if (m.get("notes") != null) {
                    String notes = m.get("notes").toString();
                    hotel.setNotes(notes);
                }
                records.add(hotel);
            }
        } catch (Exception e) {
            throw e;
        }
        return records;
    }

    //not complete
    public final Map getHotelById(String tableName, String primaryKeyField,
            Object keyValue) throws SQLException {
        
        
        
        return null;
    }
    
    
    @Override
    public void deleteHotels(String tableName, String whereField,
            Object whereValue) throws SQLException {
        try {
            db.deleteRecords(tableName, whereField, whereValue);
        } catch (SQLException sqle) {
            throw sqle;

        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void saveHotels(Hotel hotel) throws SQLException, Exception {
        HotelDAO dao = new HotelDAO(new DB_MySql());
        dao.openConnection();
        
        String tableName = "hotel";

        List<String> colDescriptors = new ArrayList<>();
        colDescriptors.add("hotel_name");
        colDescriptors.add("street_address");
        colDescriptors.add("city");
        colDescriptors.add("state");
        colDescriptors.add("postal_code");
        colDescriptors.add("notes");

        List<String> colValues = new ArrayList<>();
        colValues.add(hotel.getHotelName());
        colValues.add(hotel.getStreetAddress());
        colValues.add(hotel.getCity());
        colValues.add(hotel.getState());
        colValues.add(hotel.getPostalCode());
        colValues.add(hotel.getNotes());

        try {
            if (hotel.getHotelId() == null) {
                db.insertRecords(tableName, colDescriptors, colValues);
            } else {
                db.updateRecords(
                        tableName, colDescriptors,
                        colValues, "hotel_id", hotel.getHotelId());
            }
        } catch (SQLException sqle) {
            throw sqle;

        } catch (Exception e) {
            throw e;
        }

    }

    public static void main(String[] args) throws Exception {
//        HotelDAO db = new HotelDAO();
//        Class.forName(db.driverClassName);
//        db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        String hotelName = "Test";
        String streetAddress = "";
        String city = "";
        String state = "WI";
        String postalCode = "";
        String notes = "";
        HotelDAO dao = new HotelDAO(new DB_MySql());
        Hotel hotel = new Hotel(hotelName, streetAddress, city, state,
                postalCode, notes);
//        dao.openConnection();
        dao.saveHotels(hotel);
//        dao.deleteHotel("hotel", "hotel_name", "Hotel California");
//        for (Hotel hotel : records) {
//            System.out.println(hotel);
//        }
    }
}
