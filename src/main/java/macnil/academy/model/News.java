package macnil.academy.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    private Long id;

   
    @Getter
    @Setter
    @NotEmpty
    private String titolo;
   
    @Getter
    @Setter
    @NotEmpty
    private String body;

    @Getter
    @Setter
    private Date publish_date;

   
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
