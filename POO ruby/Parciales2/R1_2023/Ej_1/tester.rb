# frozen_string_literal: true

class Hotel

  def initialize(name)
    @name = name
    @rooms_by_floor = Hash.new
  end

  def bookings
    s = "Hotel #{@name}\n"
    @rooms_by_floor.keys.sort.each do |floor|
      s += "Floor #{floor}\n"
      @rooms_by_floor[floor].values.sort.each do |room|
        s += "#{room}\n"
      end
    end
    s
  end

  def add_room(floor, room)
    @rooms_by_floor[floor] = Hash.new if @rooms_by_floor[floor].nil?
    @rooms_by_floor[floor][room] = Room.new(room)
  end

  private def check(floor, room)
    raise "Invalid Floor" if @rooms_by_floor[floor].nil?
    raise "Invalid Room" if @rooms_by_floor[floor][room].nil?
  end

  def book(floor, room)
    check(floor, room)
    raise "Room is already booked" if @rooms_by_floor[floor][room].status
    @rooms_by_floor[floor][room].status = true
  end

  def cancel(floor, room)
    check(floor, room)
    raise "Room is not booked" unless @rooms_by_floor[floor][room].status
    @rooms_by_floor[floor][room].status = false
  end
end

class Room
  attr_accessor :status
  attr_reader :number

  def initialize(number)
    @number = number
    @status = false
  end

  def to_s
    "Room #{@number} is #{@status ? "Booked" : "Available"}"
  end

  def <=>(other)
    @number <=> other.number
  end

end


# Se instancia un sistema de reservación de habitaciones del hotel Le Château Frontenac
# que arranca inicialmente sin pisos y sin habitaciones
hotel = Hotel.new('Le Château Frontenac')


hotel.add_room(1, 610) # Se agrega la habitación 610 del piso 1


hotel.add_room(1, 630)
hotel.add_room(1, 620)


# Se acepta tener habitaciones con el mismo número
# siempre y cuando estén en pisos distintos
hotel.add_room(2, 610)


# Se muestra el estado actual de todas las habitaciones del hotel
# en orden ascendente por número de piso y ascendente por número de habitación
puts hotel.bookings
# Hotel Le Château Frontenac
# Floor 1
# Room 610 is Available
# Room 620 is Available
# Room 630 is Available
# Floor 2
# Room 610 is Available


hotel.book(1, 610) # Se reserva la habitación 610 del piso 1
hotel.book(1, 630)


puts hotel.bookings
# Hotel Le Château Frontenac
# Floor 1
# Room 610 is Booked
# Room 620 is Available
# Room 630 is Booked
# Floor 2
# Room 610 is Available


begin
  hotel.book(1, 610) # Falla porque la habitación 610 del piso 1 ya está reservada
rescue RuntimeError => e
  puts e.message # Room is already booked
end


begin
  hotel.book(-1, 610) # Falla pues no existe el piso -1
rescue RuntimeError => e
  puts e.message # Invalid Floor
end


hotel.cancel(1, 630) # Se cancela la reserva de la habitación 610 del piso 1


begin
  hotel.cancel(2, 620) # Falla pues no existe la habitación 620 en el piso 1
rescue RuntimeError => e
  puts e.message # Invalid Room
end


begin
  hotel.cancel(2, 610) # Falla porque la habitación 610 del piso 2 no tiene una reserva
rescue RuntimeError => e
  puts e.message # Room is not booked
end


hotel.book(2, 610)


puts hotel.bookings
# Hotel Le Château Frontenac
# Floor 1
# Room 610 is Booked
# Room 620 is Available
# Room 630 is Available
# Floor 2
# Room 610 is Booked

