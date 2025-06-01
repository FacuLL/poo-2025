# frozen_string_literal: true
require_relative 'day_limited_theme_park_passholders'
require_relative 'park_limited_them_park_passholders'

# Se crea un sistema de reservas para Foo
passholders = ThemeParkPassholders.new('Foo')
puts passholders.visitor # Foo
# Se reserva el parque Magic Kingdom para el día 11 del mes
passholders.add_pass('Magic Kingdom', 11)
passholders.add_pass('Magic Kingdom', 15)
passholders.add_pass('Magic Kingdom', 11) # No se agrega porque ya existe
passholders.add_pass('Epcot', 15)
passholders.add_pass('Disney Springs', 14)
# Imprime todas los pases en ORDEN DESCENDENTE POR DIA
# y desempata alfabéticamente por parque
passholders.passes.each { |pass| p pass }
# Epcot on day 15
# Magic Kingdom on day 15
# Disney Springs on day 14
# Magic Kingdom on day 11
# Se crea un sistema de reservas para Foo
# donde no se puede reservar más de un parque por día
# y sólo se pueden reservar hasta 3 días
days_passholders = DayLimitedThemeParkPassholders.new('Foo', 3)
puts days_passholders.visitor # Foo
days_passholders.add_pass('Magic Kingdom', 11)
# Se arroja un error pues ya hay un pase para ese día
begin
  days_passholders.add_pass('Epcot', 11)
rescue => e
  puts e.message # Cannot add pass
end
days_passholders.add_pass('Epcot', 10)
days_passholders.add_pass('Magic Kingdom', 13)
# Se arroja un error pues ya se alcanzó la cantidad máxima de reservas
begin
  days_passholders.add_pass('Disney Springs', 15)
rescue => e
  puts e.message # Cannot add pass
end
# Imprime todas los pases en ORDEN DESCENDENTE POR DIA
# y desempata alfabéticamente por parque
days_passholders.passes.each { |pass| p pass }
# Magic Kingdom on day 13
# Magic Kingdom on day 11
# Epcot on day 10


# Se crea un sistema de reservas para Foo
# donde no se puede reservar el mismo parque más de una vez
# y sólo se pueden reservar parques de un listado de permitidos
included_parks = ['Magic Kingdom', 'Epcot', 'Disney Studios']
parks_passholders = ParkLimitedThemParkPassholders.new('Foo', included_parks)
puts parks_passholders.visitor # Foo
parks_passholders.add_pass('Magic Kingdom', 11)
# Se arroja un error pues ya existe un pase para Magic Kingdom
begin
  parks_passholders.add_pass('Magic Kingdom', 13)
rescue => e
  puts e.message # Cannot add pass
end
parks_passholders.add_pass('Epcot', 9)
# Se arroja un error pues ya existe un pase para Epcot
begin
  parks_passholders.add_pass('Epcot', 13)
rescue => e
  puts e.message # Cannot add pass
end
# Se arroja un error pues no está en la lista de parques permitidos
begin
  parks_passholders.add_pass('Disney Springs', 13)
rescue => e
  puts e.message # Cannot add pass
end
# Imprime todas los pases en ORDEN DESCENDENTE POR DIA
# y desempata alfabéticamente por parque
parks_passholders.passes.each { |pass| p pass }
# Magic Kingdom on day 11
# Epcot on day 9

