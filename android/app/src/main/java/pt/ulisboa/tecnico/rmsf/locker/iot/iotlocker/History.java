package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import java.util.List;

/**
 * Created by brunofgo on 02/04/17.
 */

public class History {


    private List<HistoryBean> history;

    public List<HistoryBean> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryBean> history) {
        this.history = history;
    }

    public static class HistoryBean {
        /**
         * id : 78719
         * day : 2017-05-02
         * hour : 10:00:00
         * name : Afonso Costa
         */

        private String id;
        private String day;
        private String hour;
        private String name;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
