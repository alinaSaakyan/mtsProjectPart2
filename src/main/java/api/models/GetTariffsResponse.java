package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetTariffsResponse {
    public List<Tariff> tariffs;

}
