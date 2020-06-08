package hr.tvz.kerhin.studapp.models;

import lombok.Data;

import javax.persistence.*;
import javax.print.DocFlavor;

@Data
@Entity
@Table (name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length =  20)
    private String name;


    public Semester() {
    }

    public Semester(Long id, String  name){
        this.id = id;
        this.name = name;
    }


}
