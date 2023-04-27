Feature: CreateUser
  @CreateUser
  Scenario Outline: Tạo User
    Given Gọi Api tạo user
    When Bắt đầu tạo user với các thông tin là
      |name|gender|email|status|
      |<name>|<gender>|<email>|<status>|
    When Gọi Api Get Líst User
    Then Verify List Ket qua
    Examples:
      |name|gender|email|status|
      |okbede|male|fffdaas@gmail.com|active|