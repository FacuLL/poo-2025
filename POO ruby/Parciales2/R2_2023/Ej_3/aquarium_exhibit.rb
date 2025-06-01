# frozen_string_literal: true
require_relative 'aquarium_reservation'

class AquariumExhibit
  def initialize(name)
    @name = name
    @reservations = []
  end


  def create_reservation(visitor, day)
    AquariumReservation.new(visitor, day)
  end


  def reserve_exhibit(visitor, day)
    @reservations << create_reservation(visitor, day)
  end


  def cancel_reservation(visitor, day) # delete elimina todas las apariciones
    @reservations.delete(create_reservation(visitor, day))
  end


  attr_reader :reservations
  private :create_reservation
end


