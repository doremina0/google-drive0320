package google.drive.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DashBoard_table")
@Data
public class DashBoard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String filename;
    private Integer filesize;
    private String path;
    private String filetype;
    private Boolean isIndexed;
    private Boolean isUploaded;
    private String url;
}
