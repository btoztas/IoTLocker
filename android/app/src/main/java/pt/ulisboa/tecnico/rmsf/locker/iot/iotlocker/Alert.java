package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import java.util.List;

/**
 * Created by brunofgo on 22/04/17.
 */

public class Alert {


    private List<AlertBean> alert;

    public List<AlertBean> getAlert() {
        return alert;
    }

    public void setAlert(List<AlertBean> alert) {
        this.alert = alert;
    }

    public static class AlertBean {
        /**
         * id : 0
         * day : 0000-00-00
         * hour : -00:00:11
         * description : OLAAA
         */

        private String id;
        private String day;
        private String hour;
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
