package models;

import java.sql.Connection;
import java.util.List;

public class CgwDataStore {
    private Connection connection;
    private BusinessesEntity businessesEntity;

    private LocationsEntity locationsEntity;
    private InventoriesEntity inventoriesEntity;
    private CategoriesEntity categoriesEntity;
    private ProductsEntity productsEntity;
    private StatusEntity statusEntity;
    private UsersEntity usersEntity;
    private InvOperationEntity invOperationEntity;
    private InvTransaccionEntity invTransaccionEntity;
    private OrdersEntity ordersEntity;
    private EventsEntity eventsEntity;
    private ProductsInventoriesEntity productsInventoriesEntity;
    private OrderProductsEntity orderProductsEntity;

    public CgwDataStore(Connection connection) {
        this.connection = connection;
    }

    public CgwDataStore() {
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    /**Business**/
    public BusinessesEntity getBusinessesEntity() {
        if(businessesEntity == null){
            businessesEntity =new BusinessesEntity();
            businessesEntity.setConnection(connection);
        }
        return businessesEntity;
    }


    public CgwDataStore setBusinessesEntity(BusinessesEntity businessesEntity) {
        this.businessesEntity = businessesEntity;
        return this;
    }

    public List<Business> findAllBusiness() {
        return connection == null ? null: getBusinessesEntity().findAllBusiness();
    }

    public List<Business> findBestBusinesses(){
        return connection==null?null:getBusinessesEntity().findBestsBusinesses();
    }
    public List<Business> findBadBusinesses(){
        return connection==null?null:getBusinessesEntity().findBadBusinesses();
    }

    public Business findByIdBusiness(String ruc){
        return getBusinessesEntity().findByRUC(ruc);
    }

    public Business findByNameBusiness(String name){
        return getBusinessesEntity().findByName(name);
    }

    public Business findBestBusiness(){
        return connection==null?null:getBusinessesEntity().findBestBusiness();
    }

    public List<Business> findByTypeBusiness(String type){
        return connection==null?null:getBusinessesEntity().findByType(type);
    }
    public boolean createBusiness(Business business){
        return connection==null?false:
                getBusinessesEntity().createBusiness(business);
    }


    public boolean deleteBusiness(String  ruc){
        return getBusinessesEntity().deleteBusiness(ruc);
    }

    public boolean updateBusiness(String ruc,String name,String address,String phone,String email){
        return connection==null?false: getBusinessesEntity().updateBusiness(ruc, name, address, phone, email);
    }


    /**Location**/
    public LocationsEntity getLocationsEntity() {
        if(locationsEntity==null){
            locationsEntity=new LocationsEntity();
            locationsEntity.setConnection(connection);
        }
        return locationsEntity;
    }


    public List<Location> findAllLocations(){
        return getLocationsEntity().findAllLocations(getBusinessesEntity(),getInventoriesEntity());
    }
    public List<Location> findLocationsByRuc(String ruc){
        return getLocationsEntity().findLocationsByRuc(ruc, getBusinessesEntity(),getInventoriesEntity());
    }

    public Location findByIdLocations(int id){
        return getLocationsEntity().findByIdLocation(id,getBusinessesEntity(),getInventoriesEntity());
    }

    public Location findByAddressLocation(String address){
        return getLocationsEntity().findByAddress(address,getBusinessesEntity(),getInventoriesEntity());
    }



    public boolean createLocations(Location location){
        return  getLocationsEntity().createLocation(location);
    }

    public boolean updateAddressLocation(Location location){
        return getLocationsEntity().updateAddressLocations(location);
    }

    public boolean updateMaxCapacityLocation(Location location){
        return getLocationsEntity().updateMaxCapacity(location);
    }

    public boolean updateActualCapacityLocation(Location location){
        return getLocationsEntity().updateActualCapacityLocations(location);
    }

    public boolean updateLocation(Location location){
        return getLocationsEntity().updateLocations(location);
    }

    public boolean changeSchedulesLocations(Location location){
        return getLocationsEntity().updateSchedulesLocations(location);
    }


    public CgwDataStore setLocationsEntity(LocationsEntity locationsEntity) {
        this.locationsEntity = locationsEntity;
        return this;
    }

    /**Inventory**/
    public InventoriesEntity getInventoriesEntity() {
        if(inventoriesEntity==null){
            inventoriesEntity=new InventoriesEntity();
            inventoriesEntity.setConnection(connection);
        }
        return inventoriesEntity;
    }

    public CgwDataStore setInventoriesEntity(InventoriesEntity inventoriesEntity) {
        this.inventoriesEntity = inventoriesEntity;
        return this;
    }


    public List<Inventory> findAllInventories(){
        return getInventoriesEntity().findAllInventories();
    }

    public Inventory findInventoryById(int id){
        return getInventoriesEntity().findById(id);
    }


    public Inventory createNewInventory(int current_stock, int initial_stock, int minimal_stock){
        return getInventoriesEntity().createNewInventory(current_stock,initial_stock,minimal_stock);
    }

    public boolean removeInventory(Inventory inventory){
        return getInventoriesEntity().deleteInventory(inventory);
    }

    public boolean updateAllInventory(int id, int current_stock, int initial_stock, int minimal_stock){
        return getInventoriesEntity().updateInventory(id,current_stock,initial_stock,minimal_stock);
    }


    /**Category**/
    public CategoriesEntity getCategoriesEntity() {
        if(categoriesEntity==null){
            categoriesEntity=new CategoriesEntity();
            categoriesEntity.setConnection(connection);
        }
        return categoriesEntity;
    }

    public CgwDataStore setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
        return this;
    }


    public List<Category>  findAllCategories(){
        return getCategoriesEntity().findAllCategories();
    }

    public Category findCategryById(int id){
        return getCategoriesEntity().findById(id);
    }

    public Category findByDescription(String description){
        return getCategoriesEntity().findByDescription(description);
    }

    public Category createNewCategory(Category category){
        return getCategoriesEntity().createCategories(category);
    }
    public Category createNewCategory(String description){
        return getCategoriesEntity().createCategories(description);
    }

    public boolean updateCategory(int id,String category){
        return getCategoriesEntity().updateCategory(id, category);
    }
    public boolean removeCategory(Category category){
        return getCategoriesEntity().deleteCategory(category);
    }

    /**Product**/
    public ProductsEntity getProductsEntity() {
        if(productsEntity==null){
            productsEntity=new ProductsEntity();
            productsEntity.setConnection(connection);
        }
        return productsEntity;
    }

    public CgwDataStore setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
        return this;
    }


    public List<Product> findAllProducts(){
        return getProductsEntity().findAllProducts(getCategoriesEntity());
    }

    public Product findProductById(int id){
        return getProductsEntity().findById(id,getCategoriesEntity());
    }

    public Product findByNameProduct(String name){
        return getProductsEntity().findByName(name,getCategoriesEntity());
    }

    public boolean createNewProduct(Product product){
        return getProductsEntity().insertProduct(product);
    }

    public boolean updateProduct(Product product){
        return getProductsEntity().changeProduct(product);
    }

    public boolean changePriceProduct(Product product){
        return getProductsEntity().changePriceProduct(product);
    }

    public boolean changeScore(Product product){
        return getProductsEntity().changeScoreProduct(product);
    }
    public boolean deleteProduct(Product product){
        return getProductsEntity().deleteProduct(product);
    }


    /**Status**/

    public StatusEntity getStatusEntity() {
        if(statusEntity==null){
            statusEntity=new StatusEntity();
            statusEntity.setConnection(connection);
        }
        return statusEntity;
    }

    public CgwDataStore setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
        return this;
    }


    public List<Status> findAllStatus(){
        return getStatusEntity().findAllStatus();
    }

    public Status findByIdStatus(int id){
        return getStatusEntity().findByIdStatus(id);
    }

    public Status findByType(String type){
        return getStatusEntity().finByStatusType(type);
    }


    public boolean updateStatusType(Status status){
        return getStatusEntity().updateStatusType(status);
    }

    /**User**/


    public UsersEntity getUsersEntity(){
        if(usersEntity==null){
            usersEntity=new UsersEntity();
            usersEntity.setConnection(connection);
        }
        return usersEntity;
    }

    public CgwDataStore setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
        return this;
    }



    public List<User> findAllUser(){
        return getUsersEntity().findAllUsers(getStatusEntity());
    }

    public User findByIdUser(int id){
        return getUsersEntity().findByIdUser(id,getStatusEntity());
    }

    public User findByFirstName(String firstName){
        return getUsersEntity().findByFirstName(firstName,getStatusEntity());
    }

    public User findByEmailPass(String email, String password){
        return getUsersEntity().findByNameAndPass(email,password,getStatusEntity());
    }

    public User findByLastName(String lastName){
        return getUsersEntity().findByLastName(lastName,getStatusEntity());
    }

    public User findByManageId(int id){
        return getUsersEntity().findByManagerId(id,getStatusEntity());
    }

    public boolean createNormalUser(User user){
        return getUsersEntity().createNormalUsers(user);
    }

    public boolean createAdminUser(User user){
        return getUsersEntity().createAdminUsers(user);
    }

    public boolean createAdminUser2(User user){
        return getUsersEntity().createAdminUsers2(user);
    }
    public boolean updateUser(User user){
        return getUsersEntity().updateAttributesUser(user);
    }

    public boolean changeStatus(User user){
        return getUsersEntity().changeStatusUser(user);
    }

    public boolean deleteUser(User user){
        return getUsersEntity().deleteUsers(user);
    }

    /**Inventory Operation **/
    public InvOperationEntity getInvOperationEntity() {
        if(invOperationEntity==null){
            invOperationEntity=new InvOperationEntity();
            invOperationEntity.setConnection(connection);
        }
        return invOperationEntity;
    }

    public CgwDataStore setInvOperationEntity(InvOperationEntity invOperationEntity) {
        this.invOperationEntity = invOperationEntity;
        return this;
    }

    public List<InventoryOperation> findAllInvOperation(){
        return getInvOperationEntity().findAllInvOperations(getInventoriesEntity(),getProductsEntity(),getInvTransaccionEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public InventoryOperation findByIdIO(int id){
        return getInvOperationEntity().findByInOperationId(id,getInventoriesEntity(),getProductsEntity(),getInvTransaccionEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public InventoryOperation findByInventoryIdIO(int id){
        return getInvOperationEntity().findByInventoryIdIO(id,getInventoriesEntity(),getProductsEntity(),getInvTransaccionEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public InventoryOperation findByProductsIdIO(int id){
        return getInvOperationEntity().findByProductsIdIO(id,getInventoriesEntity(),getProductsEntity(),getInvTransaccionEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public InventoryOperation findByInventoryTransaccionIdIO(int id){
        return getInvOperationEntity().findByInventoryTransaccionIdIO(id,getInventoriesEntity(),getProductsEntity(),getInvTransaccionEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public boolean createNewIO(InventoryOperation inventoryOperation){
        return getInvOperationEntity().createInvOp(inventoryOperation);
    }

    public boolean updateIO(InventoryOperation inventoryOperation){
        return getInvOperationEntity().updateInvOp(inventoryOperation);
    }

    public boolean changeQuantityIO(InventoryOperation inventoryOperation){
        return getInvOperationEntity().updateQuantityInvOp(inventoryOperation);
    }

    /**Inventory transaccion**/
    public InvTransaccionEntity getInvTransaccionEntity() {
        if(invTransaccionEntity==null){
            invTransaccionEntity=new InvTransaccionEntity();
            invTransaccionEntity.setConnection(connection);
        }
        return invTransaccionEntity;
    }

    public CgwDataStore setInvTransaccionEntity(InvTransaccionEntity invTransaccionEntity) {
        this.invTransaccionEntity = invTransaccionEntity;
        return this;
    }

    public List<InventoriesTransaccion> findAllTransaccions(){
        return getInvTransaccionEntity().findAllTransaccions(getUsersEntity(),getStatusEntity());
    }

    public InventoriesTransaccion findByIdIT(int id){
        return getInvTransaccionEntity().findByIdTransaccion(id,getUsersEntity(),getStatusEntity());
    }

    public InventoriesTransaccion findByCreatorTransaccion(int creator){
        return getInvTransaccionEntity().findByCreatorTransaccion(creator,getUsersEntity(),getStatusEntity());
    }

    public InventoriesTransaccion findByStatusTransaccion(String status){
        return getInvTransaccionEntity().findByStatusTransaccion(status,getUsersEntity(),getStatusEntity());
    }

    public InventoriesTransaccion findByUpdaterTransaccion(int updater){
        return getInvTransaccionEntity().findByUpdaterTransaccion(updater,getUsersEntity(),getStatusEntity());
    }

    public boolean createNewIT(InventoriesTransaccion inventoriesTransaccion){
        return getInvTransaccionEntity().createInvTransaccion(inventoriesTransaccion);
    }

    public boolean updateIT(InventoriesTransaccion inventoriesTransaccion){
        return getInvTransaccionEntity().updateInvTransaccion(inventoriesTransaccion);
    }

    public boolean removeIT(InventoriesTransaccion inventoriesTransaccion){
        return getInvTransaccionEntity().deleteInvTransaccion(inventoriesTransaccion);
    }

    /**Order**/

    public OrdersEntity getOrdersEntity() {
        if(ordersEntity==null){
            ordersEntity=new OrdersEntity();
            ordersEntity.setConnection(connection);
        }
        return ordersEntity;
    }

    public CgwDataStore setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
        return this;
    }

    public List<Order> findAllOrders(){
        return getOrdersEntity().findAllOrders(getUsersEntity(),getStatusEntity());
    }

    public Order findByIdOrder(int id){
        return getOrdersEntity().findByIdOrder(id,getUsersEntity(),getStatusEntity());
    }

    public Order findByCreatorOrder(int id){
        return getOrdersEntity().findByCreator(id,getUsersEntity(),getStatusEntity());
    }

    public Order findByUpdaterOrder(int id){
        return getOrdersEntity().findByUpdater(id,getUsersEntity(),getStatusEntity());
    }

    public Order createNewOrder( String state, String createdAt, User createdBy, String updatedAt, User updatedBy){
        return getOrdersEntity().createNewOrder(state, createdAt, createdBy, updatedAt, updatedBy);
    }

    public boolean removeOrder(int id,String state,String updatedAt,int updatedBy){
        return getOrdersEntity().undoOrder(id, state, updatedAt, updatedBy);
    }

    public boolean commitOrder(Order order){
        return getOrdersEntity().committedOrder(order);
    }

    /**Event**/
    public EventsEntity getEventsEntity() {
        if(eventsEntity ==null){
            eventsEntity =new EventsEntity();
            eventsEntity.setConnection(connection);
        }
        return eventsEntity;
    }

    public CgwDataStore setEventsEntity(EventsEntity eventsEntity) {
        this.eventsEntity = eventsEntity;
        return this;
    }

    public List<Event> findAllEvents(){
        return getEventsEntity().findAllEvents(getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Event findByIdPromotion(int id){
        return getEventsEntity().findByIdPromotions(id,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Event findByNamePromotion(String name){
        return getEventsEntity().findByNamePromotions(name,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Event findByStatePromotion(String status){
        return getEventsEntity() .findByStatusPromotions(status,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Event findByLocationPromo(int locationId){
        return getEventsEntity().findByLocationsIdPromotions(locationId,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Event findByProductPromo(int productsId){
        return getEventsEntity().findByProductsIdPromotions(productsId,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public boolean createNewPromo(Event event){
        return getEventsEntity().createPromotions(event);
    }

    public boolean updatePromo(Event event){
        return getEventsEntity().updatePromotions(event);
    }

    public boolean changeStatusPromo(Event event){
        return getEventsEntity().changeStatusPromotions(event);
    }

    public boolean dropPromo(Event event){
        return getEventsEntity().deletePromotion(event);
    }

    /**ProductsInventory**/
    public ProductsInventoriesEntity getProductsInventoriesEntity() {
        if(productsInventoriesEntity==null){
            productsInventoriesEntity=new ProductsInventoriesEntity();
            eventsEntity.setConnection(connection);
        }
        return productsInventoriesEntity;
    }

    public CgwDataStore setProductsInventoriesEntity(ProductsInventoriesEntity productsInventoriesEntity) {
        this.productsInventoriesEntity = productsInventoriesEntity;
        return this;
    }

    public List<ProductInventory> findAllProductsInv(){
        return getProductsInventoriesEntity().findAllProductInInventories(getInventoriesEntity(),getProductsEntity(),getCategoriesEntity());
    }
    public List<ProductInventory> findByProductsInventaryId(int id){
        return getProductsInventoriesEntity().findByProductsInventary(id,getInventoriesEntity(),getProductsEntity(),getCategoriesEntity());
    }


    public ProductInventory findByIdProductIn(int id){
        return getProductsInventoriesEntity().findByProductsInventoriesId(id,getInventoriesEntity(),getProductsEntity(),getCategoriesEntity());
    }

    public ProductInventory findByinventoryIdPI(int inventoryId){
        return getProductsInventoriesEntity().findByInventoriesId(inventoryId,getInventoriesEntity(),getProductsEntity(),getCategoriesEntity());
    }

    public ProductInventory findByProductIdPI(int productId){
        return getProductsInventoriesEntity().findByProductId(productId,getInventoriesEntity(),getProductsEntity(),getCategoriesEntity());
    }

    public boolean insertProductsInventary(ProductInventory productInventory){
        return getProductsInventoriesEntity().createProductsInventories(productInventory);
    }

    public boolean updateQuantityProductsInventary(ProductInventory productInventory){
        return getProductsInventoriesEntity().updateCantity(productInventory);
    }


    public boolean deleteProductsInventary(ProductInventory productInventory){
        return getProductsInventoriesEntity().deleteByIdPI(productInventory);
    }

    /**OrderProduct**/
    public OrderProductsEntity getOrderProductsEntity() {
        if(orderProductsEntity==null){
            orderProductsEntity=new OrderProductsEntity();
            orderProductsEntity.setConnection(connection);
        }
        return orderProductsEntity;
    }

    public  CgwDataStore setOrderProductsEntity(OrderProductsEntity orderProductsEntity) {
        this.orderProductsEntity = orderProductsEntity;
        return this;
    }

    public List<OrderProduct> findAllOrdersProducts(){
        return getOrderProductsEntity().findAllOrdersProducts(getProductsEntity(),getOrdersEntity(),getCategoriesEntity(),getUsersEntity(), getStatusEntity());
    }

    public OrderProduct findByIdOrderProducts(int id){
        return getOrderProductsEntity().findByIdOrdersProducts(id,getProductsEntity(),getOrdersEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }
    public OrderProduct findByProductIdOrdersProducts(int productId){
        return getOrderProductsEntity().findByProductIdOrdersProducts(productId,getProductsEntity(),getOrdersEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public OrderProduct findByOrdersIdOrdersProducts(int ordersId){
        return getOrderProductsEntity().findByOrdersIdOrdersProducts(ordersId,getProductsEntity(),getOrdersEntity(),getCategoriesEntity(),getUsersEntity(),getStatusEntity());
    }

    public boolean createOrderProducts(OrderProduct orderProduct){
        return getOrderProductsEntity().createOrderProducts(orderProduct);
    }

    public boolean deleteOrderProducts(OrderProduct orderProduct){
        return getOrderProductsEntity().deleteOrderProducts(orderProduct);
    }

    public boolean updateQuantityOrderProducts(OrderProduct orderProduct){
        return getOrderProductsEntity().updateQuantityOrderProducts(orderProduct);
    }


}






