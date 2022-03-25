package spring.test.mockito.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_ID",nullable = false,unique = true)
    private String  productId;

    @Column(name = "PRODUCT_NAME",nullable = false)
    private String  productName;
    @Column(name = "price",nullable = false)
    private Double  productPrice;

    @Column(name = "PRODUCT_CATEGORY",nullable = false)
    private String  productCategory;

    @Column(name = "IMAGE_URL")
    private String  productImgUrl;

    @Column(name = "PRODUCT_NUMBER")
    private Integer productNum = 0;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String  productDescription;
}
