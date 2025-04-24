package com.mrwd2009.smd.core.entity.billingmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "unifiedimpactmailer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedImpactMailerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "__pk_unifiedbillimpactmailer")
    private Long id;
    @Column(name = "contract_id")
    private String contractId;
    @Column(name = "status")
    private Integer status;
    @Column(name = "creation_date", updatable = false, insertable = false)
    private LocalDateTime creationDate;
    @Column(name = "last_modified_date", updatable = false, insertable = false)
    private LocalDateTime lastModifiedDate;
}
