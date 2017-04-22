package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import java.util.List;

/**
 * Created by brunofgo on 22/04/17.
 */

public class User {


    private List<UserBean> user;

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : KSAK
         * name : Afonso Costa
         * regday : 2017-04-22
         * reghour : 14:02:01
         */

        private String id;
        private String name;
        private String regday;
        private String reghour;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegday() {
            return regday;
        }

        public void setRegday(String regday) {
            this.regday = regday;
        }

        public String getReghour() {
            return reghour;
        }

        public void setReghour(String reghour) {
            this.reghour = reghour;
        }
    }
}
