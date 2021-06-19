package test4;

/**
 * @Author: GunGun
 * @Description:
 * @Date: Greate in 2021/6/16 16:56
 */
public class Major {
        public int id;
        public String profession;


        public Major(int id, String profession) {
            this.id = id;
            this.profession = profession;
        }


        @Override
        public String toString() {
            return "Major{" +
                    "id=" + id +
                    ", profession='" + profession + '\'' +
                    '}';
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }
}
