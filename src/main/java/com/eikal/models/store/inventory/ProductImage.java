package com.eikal.models.store.inventory;

import lombok.*;

import javax.persistence.*;

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
public class ProductImage {

    @Id
    @SequenceGenerator(name = "product_image_sequence", sequenceName = "product_image_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_sequence")
    private Long id;

    private String url;
    private String filename;
    @Lob
    private String description;
    private int position;
    private boolean isPrimary;
    private boolean deleteStatus;

    @ManyToOne
    @JoinColumn(name = "product_feature")
    private ProductFeatures product;
}
