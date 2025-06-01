# frozen_string_literal: true
require_relative 'miles_transaction'

class MilesProgram
  def initialize
    @miles_transactions = Array.new
  end

  def add_miles (origin, destination, miles)
    @miles_transactions << MilesTransaction.new(origin, destination, miles)
  end

  attr_reader :miles_transactions
end
