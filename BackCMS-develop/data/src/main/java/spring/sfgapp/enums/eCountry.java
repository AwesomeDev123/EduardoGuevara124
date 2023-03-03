package spring.sfgapp.enums;

public enum eCountry {
    Brazil,
    Mexico,
    USA,
    India,
    China
}

/*import lombok.*;
import spring.sfgapp.entity.BaseEntity;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLCOUNTRY")
public class eCountry extends BaseEntity {
    @Builder
    public eCountry(Long id, String countryName, String countryCode , eCountry regECountry) {
        super(id);
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.regECountry = regECountry;
    }

 @Column(name="country_name") private String countryName;
 @Column(name="country_code") private String countryCode;

    @ManyToOne
    @JoinColumn(name = "regtblcountry_id")
    private eCountry regECountry;

}*/
