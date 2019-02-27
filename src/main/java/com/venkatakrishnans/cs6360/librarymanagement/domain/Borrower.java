package com.venkatakrishnans.cs6360.librarymanagement.domain;

import com.venkatakrishnans.cs6360.librarymanagement.util.ZeroPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "ssn")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="borrowerSeq", initialValue=000001, allocationSize=999999)
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrower_sequence")
    @GenericGenerator(
            name = "borrower_sequence",
            strategy = "com.venkatakrishnans.cs6360.librarymanagement.util.ZeroPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = ZeroPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = ZeroPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0"),
                    @Parameter(name = ZeroPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String borrowerId;

    private String firstName;

    private String lastName;

    private String ssn;

    private String email;

    private String address;

    private String phoneNumber;

}
