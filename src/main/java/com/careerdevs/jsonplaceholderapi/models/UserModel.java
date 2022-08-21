package com.careerdevs.jsonplaceholderapi.models;

public class UserModel {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private UserCompany company;
    private UserAddress address;

    public static class UserCompany {
        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }
    }

    public static class UserAddress {
        private String suite;
        private String city;
        private String zipcode;
        private AddressGeo geo;
        public static class AddressGeo {
            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }
        }

        public AddressGeo getGeo() {
            return geo;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

    public UserAddress getAddress() {
        return address;
    }

    public UserCompany getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}