package test4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GunGun
 * @Description:
 * @Date: Greate in 2021/6/16 17:02
 */
public class Dao {

        private Connection con ;
        private PreparedStatement ps;
        private ResultSet rs ;

        //添加学生信息
        public boolean addStudent(Stu student){
            String sql = "insert into student(id,name,sex,birthday,major_id,class) values(?,?,?,?,?,?)";

            try {
                con = Sqlhelp.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1,student.getId());
                ps.setString(2,student.getName());
                ps.setString(3, student.getSex());
                ps.setString(4, student.getBirthday());
                ps.setString(5,student.getMajor());
                ps.setString(6,student.getClas());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally {
                Sqlhelp.close(con,ps,rs);
            }

            return true;
        }


        //查看学生信息(所有)
        public List<Stu> list(){

            List<Stu> list = new ArrayList<>();
            String sql = "select * from student";


            try {
                con = Sqlhelp.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Stu student = new Stu();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSex(rs.getString("sex"));
                    student.setBirthday(rs.getString("birthday"));
                    student.setMajor(rs.getString("major_id"));
                    student.setClas(rs.getString("class"));

                    list.add(student);

                }



            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                Sqlhelp.close(con,ps,rs);
            }

            return list;
        }


        //查看学生信息通过学生id
        public Stu findStudentById(int id){
            Stu student =null;
            String sql = "select * from student where id = ?";


            try {

                con = Sqlhelp.getConnection();
                ps = con.prepareStatement(sql);

                ps.setInt(1,id);
                rs = ps.executeQuery();

                while (rs.next()) {
                    student = new Stu();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSex(rs.getString("sex"));
                    student.setBirthday(rs.getString("birthday"));
                    student.setMajor(rs.getString("major_id"));
                    student.setClas(rs.getString("class"));

                }
            } catch (SQLException e) {
                e.printStackTrace();

            }finally {
                Sqlhelp.close(con,ps,rs);
            }

            return student;
        }


        //修改学生信息
        public boolean updateStudent(Stu student){
            String sql = "update student set name=?,sex=?,birthday=?,major_id=?,class=? where id=?";

            try {
                con = Sqlhelp.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,student.getName());
                ps.setString(2,student.getSex());
                ps.setString(3, student.getBirthday());
                ps.setString(4,student.getMajor());
                ps.setString(5,student.getClas());
                ps.setInt(6,student.getId());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally {
                Sqlhelp.close(con,ps,rs);
            }

            return true;

        }


        //删除学生信息
        public boolean deleteStudent(int id){
            String sql = "delete from student where id=?";


            try {
                con =Sqlhelp.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1,id);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally {
                Sqlhelp.close(con,ps,rs);
            }
            return true;
        }
}

