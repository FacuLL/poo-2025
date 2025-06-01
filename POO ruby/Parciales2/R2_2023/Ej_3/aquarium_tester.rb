# frozen_string_literal: true
require_relative 'aquarium_exhibit'
require_relative 'unique_days_ahead_aquarium_exhibit'
require_relative 'members_same_day_aquarium_exhibit'

# Se instancia un sistema de reservas para las exhibiciones de un acuario
stingray_touch = AquariumExhibit.new('Stingray Touch')
# Se registra una reserva para el visitante Visitor 2 para el día 16 del mes
stingray_touch.reserve_exhibit('Visitor 2', 16)
stingray_touch.reserve_exhibit('Visitor 1', 15)
# Se registra una segunda reserva para el visitante Visitor 1 para el día 15 del mes
stingray_touch.reserve_exhibit('Visitor 1', 15)
stingray_touch.reserve_exhibit('Visitor 1', 16)
stingray_touch.reserve_exhibit('Visitor 2', 15)


# Se obtienen todas las reservas realizadas en el orden en que se reservaron
stingray_touch.reservations.each { |reservation| p reservation }
# Aquarium Reservation of Visitor 2 for the day 16
# Aquarium Reservation of Visitor 1 for the day 15
# Aquarium Reservation of Visitor 1 for the day 15
# Aquarium Reservation of Visitor 1 for the day 16
# Aquarium Reservation of Visitor 2 for the day 15


# Se cancelan las dos reservas del visitante Visitor 1 del día 15
stingray_touch.cancel_reservation('Visitor 1', 15)


stingray_touch.reservations.each { |reservation| p reservation }
# Aquarium Reservation of Visitor 2 for the day 16
# Aquarium Reservation of Visitor 1 for the day 16
# Aquarium Reservation of Visitor 2 for the day 15


# Se instancia un sistema de reservas para las exhibiciones de un acuario
# donde la exhibición será el día 15
# y los visitantes pueden reservar sólo 2 días antes [13, 15]
# y los visitantes no pueden hacer más de una reserva por día
penguin_encounter = UniqueDaysAheadAquariumExhibit.new('Penguin Encounter', 15, 2)
penguin_encounter.reserve_exhibit('Visitor 1', 15)
begin
  penguin_encounter.reserve_exhibit('Visitor 1', 15) # Falla pues ya tiene una reserva ese día
rescue => e
  puts e.message # Cannot Reserve
end
begin
  penguin_encounter.reserve_exhibit('Visitor 2', 10) # Falla pues 10 no está en [13, 15]
rescue => e
  puts e.message # Cannot Reserve
end
penguin_encounter.reserve_exhibit('Visitor 3', 13)
penguin_encounter.reserve_exhibit('Visitor 3', 14)


penguin_encounter.reservations.each { |reservation| p reservation }
# Aquarium Reservation of Visitor 1 for the day 15
# Aquarium Reservation of Visitor 3 for the day 13
# Aquarium Reservation of Visitor 3 for the day 14


penguin_encounter.cancel_reservation('Visitor 3', 13)
penguin_encounter.reservations.each { |reservation| p reservation }
# Aquarium Reservation of Visitor 1 for the day 15
# Aquarium Reservation of Visitor 3 for the day 14


# Se instancia un sistema de reservas para las exhibiciones de un acuario
# donde la exhibición será el día 15
# y los visitantes pueden reservar sólo el mismo día
# y los visitantes tienen que ser miembros del acuario (members)
# y los visitantes no pueden hacer más de una reserva por día
members = ['Visitor 1', 'Visitor 3']
shark_feeding_tour = MembersSameDayAquariumExhibit.new('Shark Feeding Tour', 15, members)
shark_feeding_tour.reserve_exhibit('Visitor 1', 15)
begin
  shark_feeding_tour.reserve_exhibit('Visitor 1', 15) # Falla pues ya tiene una reserva
rescue => e
  puts e.message # Cannot Reserve
end
begin
  shark_feeding_tour.reserve_exhibit('Visitor 3', 16) # Falla pues no es el día 15
rescue => e # Cannot Reserve
  puts e.message
end
begin
  shark_feeding_tour.reserve_exhibit('Visitor 2', 15) # Falla pues no es miembro
rescue => e  # Cannot Reserve
  puts e.message
end
shark_feeding_tour.reserve_exhibit('Visitor 3', 15)
shark_feeding_tour.reservations.each { |reservation| p reservation }
# Aquarium Reservation of Visitor 1 for the day 15
# Aquarium Reservation of Visitor 3 for the day 15

