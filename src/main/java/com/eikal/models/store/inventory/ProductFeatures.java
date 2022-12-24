package com.eikal.models.store.inventory;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProductFeatures {

    @Id
    @SequenceGenerator(name = "product_feature_sequence", sequenceName = "product_feature_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_feature_sequence")
    private Long id;
    private String unit;
    private String size;
    private String weight;
    private String color;

    @OneToOne
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private String availability;
    private String dosageForm;
}
