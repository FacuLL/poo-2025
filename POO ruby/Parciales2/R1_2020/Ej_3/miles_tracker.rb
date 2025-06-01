# frozen_string_literal: true
require_relative 'miles_program'

class MilesTracker

  def initialize
    @miles_by_program = Hash.new
  end

  def add_miles_program(name)
    @miles_by_program[name] = MilesProgram.new
  end

  def add_miles(program_name, origin, destination, miles)
    raise ArgumentError.new "Invalid Miles Program" if @miles_by_program[program_name].nil?
    @miles_by_program[program_name].add_miles(origin, destination, miles)
  end

  def status
    return 'Miles Tracker is empty' if @miles_by_program.keys.empty?
    s = "Miles Tracker\n"
    @miles_by_program.keys.sort.each do |miles_program_name|
      s += "#{miles_program_name}\n"
      @miles_by_program[miles_program_name].miles_transactions.sort.each do |miles_transaction|
        s += "#{miles_transaction}\n"
      end
    end
    s
  end


end
