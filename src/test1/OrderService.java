package test1;


import demo2.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static List<IOrder> getOrderlist(){
        List<IOrder> orderBeans = new ArrayList<IOrder>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            String sql = "select * from t_order";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 OrderBean orderBean = new OrderBean();
                orderBean.setOrderId(rs.getString("t_order_id"));
                orderBean.setOrderName(rs.getString("t_order_name"));
                orderBeans.add(orderBean);
            }
            // 正在准备服务器上传APK，客户端下载APK，动态更新本地应用（Android插件化开发）---表情包、模块
            // 例如：客户端我要更新一个新的模块(架构设计)
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, ps, rs);
        }
            return null;
    }

    public static String getOrderPriceById(String id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            String sql = " select * from t_order where t_order_id = ? ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("t_order_price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, ps, rs);
        }
        return "";
    }


    public static String getOrderNameByUsername(String username){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            String sql = " select t_order_name from t_order where t_order_username = ?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,username);
            rs =ps.executeQuery();
            if(rs.next()){
                return rs.getString("t_order_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return "";
    }

}
