# frozen_string_literal: true
require 'set/sorted_set'
require_relative 'theme_park_pass'

class ThemeParkPassholders
  def initialize(visitor)
    @visitor = visitor
    @passes = SortedSet.new
  end


  def add_pass(theme_park, day)
    raise 'Cannot add pass' unless add_pass?(theme_park, day)
    @passes << ThemeParkPass.new(theme_park, day)
  end


  def add_pass?(theme_park, day)
    theme_park.is_a?(String) && day.positive?
  end


  attr_reader :visitor, :passes
  private :add_pass?
end


