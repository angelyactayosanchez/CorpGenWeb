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
    private PromotionsEntity promotionsEntity;
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

    public Business findByIdBusiness(String ruc){
        return getBusinessesEntity().findByRUC(ruc);
    }

    public Business findByNameBusiness(String name){
        return getBusinessesEntity().findByName(name);
    }

    public Business createBusiness(String ruc, String name, String address, String phone, String email){
        return connection==null?null:
                getBusinessesEntity().createBusiness(ruc, name, address, phone, email);
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


    public boolean createNewInventory(Inventory inventory){
        return getInventoriesEntity().createNewInventory(inventory);
    }

    public boolean removeInventory(Inventory inventory){
        return getInventoriesEntity().deleteInventory(inventory);
    }

    public boolean updateActualStock(Inventory inventory){
        return getInventoriesEntity().updateActualInventory(inventory);
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

    public boolean createNewCategory(Category category){
        return getCategoriesEntity().createCategories(category);
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

    public boolean createNewOrder(Order order){
        return getOrdersEntity().createNewOrder(order);
    }

    public boolean removeOrder(Order order){
        return getOrdersEntity().undoOrder(order);
    }

    public boolean commitOrder(Order order){
        return getOrdersEntity().committedOrder(order);
    }

    /**Promotion**/
    public PromotionsEntity getPromotionsEntity() {
        if(promotionsEntity==null){
            promotionsEntity=new PromotionsEntity();
            promotionsEntity.setConnection(connection);
        }
        return promotionsEntity;
    }

    public CgwDataStore setPromotionsEntity(PromotionsEntity promotionsEntity) {
        this.promotionsEntity = promotionsEntity;
        return this;
    }

    public List<Promotion> findAllPromotions(){
        return getPromotionsEntity().findAllPromotions(getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Promotion findByIdPromotion(int id){
        return getPromotionsEntity().findByIdPromotions(id,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Promotion findByNamePromotion(String name){
        return getPromotionsEntity().findByNamePromotions(name,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Promotion findByStatePromotion(String status){
        return getPromotionsEntity() .findByStatusPromotions(status,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Promotion findByLocationPromo(int locationId){
        return getPromotionsEntity().findByLocationsIdPromotions(locationId,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public Promotion findByProductPromo(int productsId){
        return getPromotionsEntity().findByProductsIdPromotions(productsId,getLocationsEntity(),getProductsEntity(),getCategoriesEntity(),getBusinessesEntity(),getInventoriesEntity());
    }

    public boolean createNewPromo(Promotion promotion){
        return getPromotionsEntity().createPromotions(promotion);
    }

    public boolean updatePromo(Promotion promotion){
        return getPromotionsEntity().updatePromotions(promotion);
    }

    public boolean changeStatusPromo(Promotion promotion){
        return getPromotionsEntity().changeStatusPromotions(promotion);
    }

    public boolean dropPromo(Promotion promotion){
        return getPromotionsEntity().deletePromotion(promotion);
    }

    /**ProductsInventory**/
    public ProductsInventoriesEntity getProductsInventoriesEntity() {
        if(productsInventoriesEntity==null){
            productsInventoriesEntity=new ProductsInventoriesEntity();
            promotionsEntity.setConnection(connection);
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






