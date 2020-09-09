package GAJI;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Notilist_table")
public class Notilist {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long memverId;
        private String msg;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getMemverId() {
            return memverId;
        }

        public void setMemverId(Long memverId) {
            this.memverId = memverId;
        }
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

}
