select  id, tiempo_alquiler, fecha_alquiler, fecha_devolucion, fecha_devolucion_real, pago
from alquiler
where id = :id