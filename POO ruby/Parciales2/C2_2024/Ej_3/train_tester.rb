require_relative 'train_ticket_counter'
require_relative 'limited_train_ticket_counter'
require_relative 'registered_limited_train_ticket_counter'

# Se instancia el sistema para las ventas de tickets de tren
# donde un pasajero no puede comprar más de un ticket para el mismo viaje
ttc1 = TrainTicketCounter.new


# Se concreta la compra de un ticket para el pasajero Foo
# para el viaje de Quebec City con destino a Ottawa
p ttc1.purchase('Quebec City', 'Ottawa', 'Foo') # true
# No se concreta la compra porque ya tiene un ticket para ese viaje
p ttc1.purchase('Quebec City', 'Ottawa', 'Foo') # false
# Sí puede adquirir un ticket en el sentido inverso
p ttc1.purchase('Ottawa', 'Quebec City', 'Foo') # true
p ttc1.purchase('Edmonton', 'Vancouver', 'Foo') # true
p ttc1.purchase('Edmonton', 'Vancouver', 'Bar') # true
p ttc1.purchase('Edmonton', 'Toronto', 'Bar') # true


# Se listan todas las compras concretadas en orden alfabético por estación de origen,
# luego desempata alfabético por estación destino
# y finalmente desempata descendente por nombre
ttc1.tickets.each { |t| puts t }
# Ticket from Edmonton to Toronto for Bar
# Ticket from Edmonton to Vancouver for Foo
# Ticket from Edmonton to Vancouver for Bar
# Ticket from Ottawa to Quebec City for Foo
# Ticket from Quebec City to Ottawa for Foo


# Se instancia el sistema para las ventas de tickets de tren
# donde un pasajero no puede comprar más de un ticket para el mismo viaje
# y donde la estación de origen del viaje debe ser Quebec City
# y donde la cantidad máxima de compras a concretar es 3
ttc2 = LimitedTrainTicketCounter.new(3, "Quebec City")
  p ttc2.purchase('Quebec City', 'Ottawa', 'Foo') # true
p ttc2.purchase('Quebec City', 'Ottawa', 'Foo') # false
p ttc2.purchase('Quebec City', 'Montreal', 'Bar') # true
# No se concreta la compra porque la ciudad de origen no es Quebec City
p ttc2.purchase('Ottawa', 'Quebec City', 'Foo') # false
p ttc2.purchase('Quebec City', 'Montreal', 'Foo') # true
# No se concreta la compra porque ya se alcanzó la cantidad máxima de compras concretadas
p ttc2.purchase('Quebec City', 'Montreal', 'Abc') # false


ttc2.tickets.each { |t| puts t }
# Ticket from Quebec City to Montreal for Foo
# Ticket from Quebec City to Montreal for Bar
# Ticket from Quebec City to Ottawa for Foo


# Se instancia el sistema para las ventas de tickets de tren
# donde un pasajero no puede comprar más de un ticket para el mismo viaje
# y donde la estación de origen del viaje debe ser Quebec City
# y donde la cantidad máxima de compras a concretar es 3
# y se almacenan las ventas que no se pudieron concretar para consultarlas luego
ttc3 = RegisteredLimitedTrainTicketCounter.new(3, "Quebec City")
  p ttc3.purchase('Quebec City', 'Ottawa', 'Foo') # true
p ttc3.purchase('Quebec City', 'Ottawa', 'Foo') # false
p ttc3.purchase('Quebec City', 'Montreal', 'Bar') # true
p ttc3.purchase('Ottawa', 'Quebec City', 'Foo') # false
p ttc3.purchase('Quebec City', 'Montreal', 'Foo') # true
p ttc3.purchase('Quebec City', 'Montreal', 'Abc') # false


ttc3.tickets.each { |t| puts t }
# Ticket from Quebec City to Montreal for Foo
# Ticket from Quebec City to Montreal for Bar
# Ticket from Quebec City to Ottawa for Foo


# Se listan todas las compras que no se pudieron concretar
# listando las más antiguas primero
ttc3.rejected.each { |t| puts t }
# Rejected Ticket from Quebec City to Ottawa for Foo
# Rejected Ticket from Ottawa to Quebec City for Foo
# Rejected Ticket from Quebec City to Montreal for Abc

# frozen_string_literal: true

