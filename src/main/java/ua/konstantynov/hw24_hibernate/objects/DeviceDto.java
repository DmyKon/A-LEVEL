package ua.konstantynov.hw24_hibernate.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDto {
    private String factoryId;
    private Double total;
    private Long count;
}
