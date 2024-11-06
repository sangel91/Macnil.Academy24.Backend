package macnil.academy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "broadcasts")
@NoArgsConstructor
@AllArgsConstructor
public class Broadcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long id;

    @NotEmpty
    @Getter
    @Setter
    String title;

    @NotEmpty    
    @Getter
    @Setter
    String body;

    @Getter
    @Setter
    Date creationDate;
}
