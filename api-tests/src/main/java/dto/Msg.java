package dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Msg extends ResponseType{
    String msg;

    public String getMessage(){
        return this.msg;
    }
}
