# frozen_string_literal: true

class TicketMaster

  def initialize(event_name)
    @event = Event.new(event_name)
    @tickets = []
  end

  def sell_ticket(client)
    ticket = build_ticket(client)
    @tickets << ticket
    puts "Sold #{ticket}"
  end

  def return_ticket(client)
    ticket = build_ticket(client)
    @tickets.delete(ticket) # delete elimina todas las apariciones del elemento en el array
    puts "Returned #{ticket}"
  end

  def ticket?(client)
    @tickets.include?(build_ticket(client))
  end

  def tickets_count
    @tickets.length
  end

  def sold_tickets
    @tickets
  end

  private

  def build_ticket(client)
    Ticket.new(@event, client)
  end

end

class OnlyOneTicketMaster < TicketMaster
  def initialize(event_name)
    super(event_name)
  end

  def check_client(client)
    raise "El cliente ya tiene un ticket" if self.ticket?(client)
    true
  end

  def sell_ticket(client)
    super(client) if check_client(client)
  end
end

class MaxPeopleTicketMaster < OnlyOneTicketMaster
  def initialize(event_name, max)
    super(event_name)
    @queue = Array.new
    @max = max
  end

  def check_client(client)
    super(client)
    return true if @max > self.sold_tickets.size
    @queue << client unless @queue.include?(client)
    false
  end

  def return_ticket(client)
    return @queue.delete(client) if @queue.include?(client)
    super(client)
    new_client = @queue.shift
    self.sell_ticket(new_client) unless new_client.nil?
  end

  def pending_clients()
    @queue
  end
end

class Event
  attr_reader :name

  def initialize(name)
    @name = name
  end

  def to_s
    @name
  end

  def ==(other)
    @name == other.name
  end

end

class Ticket
  attr_reader :event, :client

  def initialize(event, client)
    @event = event
    @client = client
  end

  def to_s
    "Ticket < #{@event} | #{@client} >"
  end

  def inspect
    to_s
  end

  def ==(other)
    [@event, @client] == [other.event, other.client]
  end

end


# Se instancia un administrador de tickets
#
concert = TicketMaster.new('Concert')
# Se vende un ticket al cliente
concert.sell_ticket('Client 1')
puts '----------'
# Se vende un segundo ticket para el mismo cliente anterior
concert.sell_ticket('Client 1')
puts '----------'
concert.sell_ticket('Client 2')
puts '----------'
# Se imprimen todos los tickets vendidos en orden de venta
puts "Sold: #{concert.sold_tickets}"
puts '----------'
# Se devuelven los dos tickets del cliente
concert.return_ticket('Client 1')
puts '----------'
# Se imprimen todos los tickets vendidos en orden de venta
puts "Sold: #{concert.sold_tickets}"
puts "\n##########\n\n"

#
# Se instancia un administrador de tickets donde se vende solo un ticket por cliente
#
only_one_soccer = OnlyOneTicketMaster.new('Soccer')
# Se vende un ticket al cliente
only_one_soccer.sell_ticket('Client 1')
puts '----------'
begin
  # Falla pues el cliente ya tiene un ticket para el evento
  only_one_soccer.sell_ticket('Client 1')
rescue => e
  puts e.message
end
puts '----------'
only_one_soccer.sell_ticket('Client 2')
puts '----------'
puts "Sold: #{only_one_soccer.sold_tickets}"
puts '----------'
# Se devuelve un ticket del cliente
only_one_soccer.return_ticket('Client 1')
puts '----------'
puts "Sold: #{only_one_soccer.sold_tickets}"
puts "\n##########\n\n"

#
# Se instancia un administrador de tickets donde se vende solo un ticket por cliente
# con una cantidad máxima de 2 tickets a vender
#
max_people_art = MaxPeopleTicketMaster.new('Art', 2)
# Se vende un ticket al cliente
max_people_art.sell_ticket('Client 1')
puts '----------'
begin
  # Falla pues el cliente ya tiene un ticket para el evento
  max_people_art.sell_ticket('Client 1')
rescue => e
  puts e.message
end
puts '----------'
max_people_art.sell_ticket('Client 2')
puts '----------'
# Se agregan clientes a la lista de espera pues se alcanzó la cantidad máxima de tickets vendidos
max_people_art.sell_ticket('Client 3')
max_people_art.sell_ticket('Client 4')
max_people_art.sell_ticket('Client 5')
# Si un cliente ya está en la lista de espera no se agrega
max_people_art.sell_ticket('Client 5')
puts '----------'
puts "Sold: #{max_people_art.sold_tickets}"
puts "Pending: #{max_people_art.pending_clients}"
puts '----------'
# Se devuelve un ticket del cliente
# y automáticamente se vende un ticket al primer cliente que estaba en espera
max_people_art.return_ticket('Client 1')
puts '----------'
puts "Sold: #{max_people_art.sold_tickets}"
puts "Pending: #{max_people_art.pending_clients}"
puts '----------'
# Se devuelve el ticket de un cliente que estaba en espera
max_people_art.return_ticket('Client 4')
puts '----------'
max_people_art.return_ticket('Client 2')
puts '----------'
puts "Sold: #{max_people_art.sold_tickets}"
puts "Pending: #{max_people_art.pending_clients}"
