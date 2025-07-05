<<<<<<< HEAD:src/main/java/com/restaurante/sistema_restaurante/data/model/Cupom.java
package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cupom")
@Data
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;
    private Double desconto;

    @ManyToOne
    private Reserva reserva;
}
=======
//package com.restaurante.sistema_restaurante.data.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Table(name = "tb_cupom")
//@Data
//public class Cupom {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String codigo;
//    private Double desconto;
//
//    @ManyToOne
//    private Reserva reserva;
//}
>>>>>>> 7d34b07 (Adiciona frontend e reorganiza estrutura do projeto):sistema-restaurante/src/main/java/com/restaurante/sistema_restaurante/data/model/Cupom.java
