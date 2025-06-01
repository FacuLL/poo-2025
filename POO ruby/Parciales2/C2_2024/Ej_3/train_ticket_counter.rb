# frozen_string_literal: true
require_relative 'train_ticket'
require 'set/sorted_set'

class TrainTicketCounter
  def initialize
    @tickets = SortedSet.new
  end

  def purchase(origin, destination, passenger)
    ticket = TrainTicket.new(origin, destination, passenger)
    return false if @tickets.include?(ticket)
    @tickets << ticket
    true
  end

  attr_reader :tickets
end
