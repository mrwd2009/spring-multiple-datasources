package com.mrwd2009.smd.core.entity.globalmeta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "conditionaltype")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConditionalTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "__pk_conditionaltype")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "hidden_flag")
    private Integer hiddenFlag;
    @Column(name = "creation_date", updatable = false, insertable = false)
    private LocalDateTime creationDate;
    @Column(name = "last_modified_date", updatable = false, insertable = false)
    private LocalDateTime lastModifiedDate;
}
