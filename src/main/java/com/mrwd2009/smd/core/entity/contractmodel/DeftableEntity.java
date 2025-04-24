package com.mrwd2009.smd.core.entity.contractmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "deftable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeftableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "__pk_deftable")
    private Long id;
    @Column(name = "_fk_marketplace")
    private Integer marketplaceId;
    @Column(name = "_fk_deftablesummary")
    private Integer deftableSummaryId;
    @Column(name = "version")
    private Integer version;
    @Column(name = "version_type")
    private String versionType;
    @Column(name = "creation_date", updatable = false, insertable = false)
    private LocalDateTime creationDate;
    @Column(name = "last_modified_date", updatable = false, insertable = false)
    private LocalDateTime lastModifiedDate;
}
