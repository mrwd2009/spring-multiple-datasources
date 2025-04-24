package com.mrwd2009.smd.core.entity.basemodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "billingcycle")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "__pk_billingcycle")
    private Long id;
    @Column(name = "_fk_marketplace")
    private Integer marketplaceId;
    @Column(name = "version")
    private Integer version;
    @Column(name = "version_type")
    private String versionType;
    @Column(name = "creation_date", updatable = false, insertable = false)
    private LocalDateTime creationDate;
    @Column(name = "last_modified_date", updatable = false, insertable = false)
    private LocalDateTime lastModifiedDate;
}
