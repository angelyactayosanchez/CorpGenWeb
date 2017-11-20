package  models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusEntity extends BaseEntity {


    public StatusEntity() {
        super();
        setTableName("status");
    }



    public List<Status> findByCriteria(String criteria){


        try {
            ResultSet rs = getConnection().createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Status> status = new ArrayList<>();
            while (rs.next()){
                status.add(Status.from(rs));
                return  status;
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    public List<Status> findAllStatus(){ return findByCriteria("");}

    public Status findByIdStatus(int id){
        return findByCriteria(String.format("  where id=%d",id)).get(0);
    }

    public Status findByIdStatus(Status status){
        return findByCriteria(String.format(" where id=%d",status.getId())).get(0);
    }

    public Status finByStatusType(String type){
        return findByCriteria(String.format(" where type='%s'",type)).get(0);
    }

    public boolean create(Status status){
        String sql="insert into status(type,description) values("
                +status.getType()+","
                +status.getDescription()+")";
        return executeUpdate(sql);
    }
    /*
    public boolean create(int id, String type, String description, User createdBy, String createAt, User updatedBy, String updatedAt){
        return create(new Status(id,type,description));
    }
*/
    public boolean updateStatusType(Status status){
        return executeUpdate(String.
                format("update %s set type = '%s' , description =  '%s' where id=%d",
                getTableName(),status.getType(),status.getDescription(),status.getId()));
    }

}
