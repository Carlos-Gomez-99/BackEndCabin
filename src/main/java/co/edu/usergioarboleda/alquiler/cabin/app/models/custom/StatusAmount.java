package co.edu.usergioarboleda.alquiler.cabin.app.models.custom;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusAmount implements Serializable {

    private static final long serialVersionUID = 9L;

    private Integer completed;
    private Integer cancelled;
}
