package ua.konstantynov.hw24.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDTO {
    private String factoryId;
    private Double total;
    private Long count;

    public DeviceDTO(String factoryId, Double total, Long count) {
        this.factoryId = factoryId;
        this.total = total;
        this.count = count;
    }
}
