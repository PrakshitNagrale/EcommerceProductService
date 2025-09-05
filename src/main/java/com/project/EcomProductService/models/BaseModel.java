package com.project.EcomProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass       //it will not create any table in db,only put the attributes to the class
public abstract class BaseModel {

    @Id                 //it will map the field as primary key in db
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(                  //Explicitly tells Hibernate: “always generate UUIDs, no matter which DB I’m using.”
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
   // OR @GeneratedValue(strategy = GenerationType.AUTO) -->this is specifically related to mysql
    private UUID id;

    @CreationTimestamp              //it will automatically put the date & time in db
    private Instant createdAt;     //Instant -> it stores date & time in UTC-> number of seconds/nano seconds since 1 Jan, 1970 UTC
                                   //to get ISD time form UTC --> add 5:30 hrs to it,because ISD time is ahead 5:30 hrs from UTC
    @UpdateTimestamp
    private Instant updatedAt;
}
