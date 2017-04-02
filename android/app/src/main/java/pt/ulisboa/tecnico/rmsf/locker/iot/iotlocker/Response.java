package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import java.util.List;

/**
 * Created by brunofgo on 02/04/17.
 */

public class Response {


    private List<UserBean> user;

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 78719
         * name : Afonso Costa
         */

        private String id;
        private String name;

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
    }
}
