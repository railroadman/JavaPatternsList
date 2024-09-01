package com.example.designpatterns.structural.proxy;

    // Subject
    interface VideoService {
        void playVideo(String videoId);
    }

    // Real Subject
    class RealVideoService implements VideoService {
        @Override
        public void playVideo(String videoId) {
            System.out.println("Playing video: " + videoId);
        }
    }

    // Proxy
    class VideoServiceProxy implements VideoService {
        private RealVideoService realVideoService;
        private String userRole;

        public VideoServiceProxy(String userRole) {
            this.userRole = userRole;
        }

        @Override
        public void playVideo(String videoId) {
            if (userRole.equals("admin") || userRole.equals("premium")) {
                if (realVideoService == null) {
                    realVideoService = new RealVideoService();
                }
                System.out.println("Access granted.");
                realVideoService.playVideo(videoId);
            } else {
                System.out.println("Access denied. Upgrade to premium or login as admin to watch this video.");
            }
        }
    }

    // Demo class
    public class ProxyDemo {
        public static void runDemo() {
            VideoService regularUserService = new VideoServiceProxy("regular");
            VideoService premiumUserService = new VideoServiceProxy("premium");
            VideoService adminUserService = new VideoServiceProxy("admin");

            System.out.println("Regular user trying to play video:");
            regularUserService.playVideo("12345");

            System.out.println("\nPremium user trying to play video:");
            premiumUserService.playVideo("12345");

            System.out.println("\nAdmin user trying to play video:");
            adminUserService.playVideo("12345");
        }
    }