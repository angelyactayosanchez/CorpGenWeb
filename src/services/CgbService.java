package services;

import models.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CgbService {
    private Connection connection;
    private CgwDataStore dataStore;

    public CgbService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new CgwDataStore();
            connection = ((DataSource) context
                    .lookup("MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CgwDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(CgwDataStore dataStore) {
        this.dataStore = dataStore;
    }



    /**Business**/

    public List<Business> getAllBusiness(){
        return getDataStore().findAllBusiness();
    }
    public List<Business> getBestBusinesses(){return getDataStore().findBestBusinesses();}
    public List<Business>  getBadBusiness(){return getDataStore().findBadBusinesses(); }
    public List<Business>  getTypeBusiness(String type){return getDataStore().findByTypeBusiness(type);}

    public Business getBusinessByRUC(String ruc){
        return getDataStore().findByIdBusiness(ruc);
    }

    public Business getBusinessByName(String name){return getDataStore().findByNameBusiness(name); }

    public Business getBestBusiness(){return  getDataStore().findBestBusiness();}

    public boolean createBusiness(Business business){
        return getDataStore().createBusiness(business);
    }


    public boolean deleteBusiness(String ruc){
        return getDataStore().deleteBusiness(ruc);
    }

    public boolean updateBusiness(String ruc,String name,String address,String phone,String email){
        return getDataStore().updateBusiness(ruc, name, address, phone, email);
    }


    /** Status**/

    public  List<Status> getAllStatus(){return  getDataStore().findAllStatus();}

    public Status getStatusById(int id){ return getDataStore().findByIdStatus(id);}

    public Status getStatusByType(String type){return getDataStore().findByType(type);}

    public boolean changeStatus(Status status){ return getDataStore().updateStatusType(status);}

    /**Location**/

    public List<Location> getAllLocations(){return getDataStore().findAllLocations();}

    public List<Location> getLocationsByRuc(String ruc){return getDataStore().findLocationsByRuc(ruc);}

    public Location getLocationById(int id){return getDataStore().findByIdLocations(id);}

    public Location getLocationsByAddress(String address){return getDataStore().findByAddressLocation(address);}

    public boolean createLocation(Location location){return getDataStore().createLocations(location);}

    public boolean updateLocation(Location location){ return getDataStore().updateLocation(location);}

    public boolean updateAddressLocation(Location location){return getDataStore().updateAddressLocation(location);}

    public boolean updateMaxCapacityLocation(Location location){return getDataStore().updateMaxCapacityLocation(location);}

    public boolean updateActualCapacityLocation(Location location){ return getDataStore().updateActualCapacityLocation(location);}

    public boolean changeSchedules(Location location){return getDataStore().changeSchedulesLocations(location);}

    /**Inventory**/

    public List<Inventory> getAllInventories(){ return getDataStore().findAllInventories();}

    public Inventory getInventoryById(int id){return getDataStore().findInventoryById(id);}

    public Inventory createInventory(int current_stock, int initial_stock, int minimal_stock)
    { return getDataStore().createNewInventory(current_stock,initial_stock,minimal_stock);}

    public boolean updateInventoryStock(int id, int current_stock, int initial_stock, int minimal_stock)
    { return getDataStore().updateAllInventory(id,current_stock,initial_stock,minimal_stock);}

    public boolean removeInventory(Inventory inventory){return getDataStore().removeInventory(inventory);}

    /**Category**/

    public List<Category> getAllCategories(){ return getDataStore().findAllCategories();}

    public Category getCategoryById(int id){return getDataStore().findCategryById(id);}

    public Category getCategoryByName(String name){ return getDataStore().findByDescription(name);}

    public Category createCategory(Category category){ return getDataStore().createNewCategory(category);}

    public Category createCategory(String description){ return getDataStore().createNewCategory(description);}

    public boolean updateCategory(int id,String description){return getDataStore().updateCategory(id, description);}

    public boolean removeCategory(Category category){ return getDataStore().removeCategory(category);}

    /**Product**/

    public List<Product> getAllProducts(){ return getDataStore().findAllProducts();}

    public Product getProductById(int id){ return  getDataStore().findProductById(id);}

    public Product getProductByName(String name){ return getDataStore().findByNameProduct(name);}

    public boolean createProduct(Product product){ return getDataStore().createNewProduct(product);}

    public boolean updateProduct(Product product){return getDataStore().updateProduct(product);}

    public boolean changePriceProduct(Product product){return getDataStore().changePriceProduct(product);}

    public boolean changeScore(Product product){return getDataStore().changeScore(product); }

    public boolean deleteProduct(Product product){return getDataStore().deleteProduct(product);}


    /**User**/

    public List<User> getAllUsers(){ return getDataStore().findAllUser();}

    public User getUserById(int id){return getDataStore().findByIdUser(id);}

    public User getUserByFirstName(String firstName){return getDataStore().findByFirstName(firstName);}

    public User getUserByValidation(String email,String password){return getDataStore().findByEmailPass(email,password);}

    public User getUserByLastName(String lastName){
        return getDataStore().findByLastName(lastName);
    }

    public User getUserByManageId(int id){ return getDataStore().findByManageId(id); }

    public boolean createNormalUser(User user){
        return getDataStore().createNormalUser(user);
    }

    public boolean createAdminUser(User user){ return  getDataStore().createAdminUser(user); }

    public boolean createAdminUser2(User user){return getDataStore().createAdminUser2(user); }

    public boolean updateUser(User user){
        return getDataStore().updateUser(user);
    }

    public boolean changeStatus(User user){return getDataStore().changeStatus(user); }

    public boolean deleteUser(User user){return getDataStore().deleteUser(user); }

    /**Inventory Operation **/



    public List<InventoryOperation> getAllInvOperation(){ return getDataStore().findAllInvOperation();  }

    public InventoryOperation getInvOperationById(int id){ return getDataStore().findByIdIO(id);}

    public InventoryOperation getInvOpByInvId(int id){return getDataStore().findByInventoryIdIO(id);}

    public InventoryOperation getInvOpByProductId(int id){return getDataStore().findByProductsIdIO(id);}

    public InventoryOperation getInvOpByITId(int id){return getDataStore().findByInventoryTransaccionIdIO(id);}

    public boolean createInventoryOperation(InventoryOperation inventoryOperation){return getDataStore().createNewIO(inventoryOperation); }

    public boolean updateInventoryOperation(InventoryOperation inventoryOperation){return getDataStore().updateIO(inventoryOperation);  }

    public boolean changeQuantityIO(InventoryOperation inventoryOperation){return getDataStore().changeQuantityIO(inventoryOperation);}

    /**Inventory transaccion**/

    public List<InventoriesTransaccion> getAllTransaccions(){
        return getDataStore().findAllTransaccions();
    }

    public InventoriesTransaccion getTransaccionBy(int id){
        return getDataStore().findByIdIT(id);
    }

    public InventoriesTransaccion getTransaccionByCreatorId(int id){
        return getDataStore().findByCreatorTransaccion(id);
    }

    public InventoriesTransaccion getTransaccionByStatus(String status){
        return getDataStore().findByStatusTransaccion(status);
    }

    public InventoriesTransaccion getTransaccionByUpdater(int updater){
        return getDataStore().findByUpdaterTransaccion(updater);
    }

    public boolean createInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return getDataStore().createNewIT(inventoriesTransaccion);
    }

    public boolean updateInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return getDataStore().updateIT(inventoriesTransaccion);
    }

    public boolean removeInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return getDataStore().removeIT(inventoriesTransaccion);
    }



    /**Order**/

    public List<Order> getAllOrders(){
        return getDataStore().findAllOrders();
    }

    public Order getOrderById(int id){
        return getDataStore().findByIdOrder(id);
    }

    public Order getOrderByCreator(int id){
        return getDataStore().findByCreatorOrder(id);
    }

    public Order getOrderByUpdater(int id){
        return getDataStore().findByUpdaterOrder(id);
    }

    public Order createOrder( String state, String createdAt, User createdBy, String updatedAt, User updatedBy){
        return getDataStore().createNewOrder(state, createdAt, createdBy, updatedAt, updatedBy);
    }

    public boolean removeOrder(int id,String state,String updatedAt,int updatedBy){
        return getDataStore().removeOrder(id, state, updatedAt, updatedBy);
    }

    public boolean commitOrder(Order order){
        return getDataStore().commitOrder(order);
    }

    /**Event**/
    public List<Event> getAllEvents(){
        return getDataStore().findAllEvents();
    }

    public Event getPromotionById(int id){
        return getDataStore().findByIdPromotion(id);
    }

    public Event getPromotionByName(String name){
        return getDataStore().findByNamePromotion(name);
    }

    public Event getPromotionByState(String status){
        return getDataStore().findByStatePromotion(status);
    }

    public Event getPromotionByLocation(int locationId){
        return getDataStore().findByLocationPromo(locationId);
    }

    public Event getPromotionByProduct(int productsId){
        return getDataStore().findByProductPromo(productsId);
    }

    public boolean createPromotion(Event event){  return getDataStore().createNewPromo(event); }

    public boolean updatePromotion(Event event){
        return getDataStore().updatePromo(event);
    }

    public boolean changeStatusPromo(Event event){return getDataStore().changeStatusPromo(event); }

    public boolean deletePromo(Event event){return getDataStore().dropPromo(event); }

    /**ProductsInventory**/

    public List<ProductInventory> getAllProductsInv(){
        return getDataStore().findAllProductsInv();
    }
    public List<ProductInventory> getProductsInventary(int id){return getDataStore().findByProductsInventaryId(id);}

    public ProductInventory getProductInById(int id){return getDataStore().findByIdProductIn(id);}

    public ProductInventory getProductInByInvenId(int inventoryId){
        return getDataStore().findByinventoryIdPI(inventoryId);
    }

    public ProductInventory getProductInByProductId(int productId){
        return getDataStore().findByProductIdPI(productId);
    }

    public boolean insertProductsInventary(ProductInventory productInventory){
        return getDataStore().insertProductsInventary(productInventory);
    }

    public boolean updateQuantityProductsInventary(ProductInventory productInventory){
        return getDataStore().updateQuantityProductsInventary(productInventory);
    }

    public boolean deleteProductsInventary(ProductInventory productInventory){
        return getDataStore().deleteProductsInventary(productInventory);
    }

    /**OrderProduct**/

    public List<OrderProduct> getAllOrdersProducts(){
        return getDataStore().findAllOrdersProducts();
    }

    public OrderProduct getOrderProductsById(int id){
        return getDataStore().findByIdOrderProducts(id);
    }
    public OrderProduct getOrdersProductsByProductId(int productId){
        return getDataStore().findByProductIdOrdersProducts(productId);
    }

    public OrderProduct getOrdersProductsByOrdersId(int ordersId){
        return getDataStore().findByOrdersIdOrdersProducts(ordersId);
    }

    public boolean createOrderProducts(OrderProduct orderProduct){
        return getDataStore().createOrderProducts(orderProduct);
    }

    public boolean deleteOrderProducts(OrderProduct orderProduct){
        return getDataStore().deleteOrderProducts(orderProduct);
    }

    public boolean updateQuantityOrderProducts(OrderProduct orderProduct){
        return getDataStore().updateQuantityOrderProducts(orderProduct);
    }








}





